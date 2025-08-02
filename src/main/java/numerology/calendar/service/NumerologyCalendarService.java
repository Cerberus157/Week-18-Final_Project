package numerology.calendar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numerology.calendar.controller.error.ResourceNotFoundException;
import numerology.calendar.dao.CalendarDayDao;
import numerology.calendar.dao.CompatibilityLabelDao;
import numerology.calendar.dao.CompatibilityMatrixDao;
import numerology.calendar.dao.UserProfileDao;
import numerology.calendar.entity.CalendarDay;
import numerology.calendar.entity.CompatibilityLabel;
import numerology.calendar.entity.CompatibilityMatrix;
import numerology.calendar.entity.UserProfile;

@Service
public class NumerologyCalendarService {

    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private CalendarDayDao calendarDayDao;
    @Autowired
    private CompatibilityLabelDao compatibilityLabelDao;
    @Autowired
    private CompatibilityMatrixDao compatibilityMatrixDao;

    /**
     * Creates a new user, calculates lifepath number,
     * and generates their calendar for the current year.
     */
    public UserProfile createUser(String fullName, LocalDate birthDate) {
        // ✨ Step 1: Calculate lifepath
        int lifepath = calculateLifepath(birthDate);

        // ✨ Step 2: Create and save user profile
        UserProfile newUser = new UserProfile();
        newUser.setFullName(fullName);
        newUser.setBirthDate(birthDate);
        newUser.setLifepathNumber(lifepath);
        UserProfile savedUser = userProfileDao.save(newUser);

        // ✨ Step 3: Generate symbolic calendar
        generateCalendar(savedUser.getUserId(), LocalDate.now().getYear());

        return savedUser;
    }

    /*
     * Generates and persists a numerology calendar for a user and year.
     * Each date is computed with a symbolic day number based on numeric reduction.
     */
    public List<CalendarDay> generateCalendar(Long userId, int year) {
        Optional<UserProfile> userOpt = userProfileDao.findById(userId);
        if (userOpt.isEmpty()) return List.of();

        UserProfile user = userOpt.get();
        int lifepath = user.getLifepathNumber();

        List<CalendarDay> calendar = new ArrayList<>();

        for (int i = 1; i <= 365; i++) {
            LocalDate date = LocalDate.ofYearDay(year, i);
            int dayNumber = reduceToSingleDigit(date.getYear() + date.getMonthValue() + date.getDayOfMonth());

            CalendarDay day = new CalendarDay();
            day.setDate(date);
            day.setCalendarDayNumber(dayNumber);
            day.setUserProfile(user);

            calendar.add(calendarDayDao.save(day));
        }
        return calendar;
    }

    /**
     * Calculates lifepath number using digit reduction logic from a birthdate.
     */
    public int calculateLifepath(LocalDate birthdate) {
        int rawSum = birthdate.getYear() + birthdate.getMonthValue() + birthdate.getDayOfMonth();
        return reduceToSingleDigit(rawSum);
    }

    /**
     * Reduces a number to a single digit by summing its digits repeatedly.
     * Used in both lifepath and day number calculations.
     */
    public int reduceToSingleDigit(int number) {
        while (number >= 10) {
            number = String.valueOf(number).chars()
                     .map(Character::getNumericValue)
                     .sum();
        }
        return number;
    }

    /**
     * Retrieves a compatibility label based on lifepath and calendar day number.
     * Returns null if not found — allows graceful fallback.
     */
    public CompatibilityLabel getCompatibility(int lifepath, int calendarDayNumber) {
        return compatibilityMatrixDao
            .findByLifepathNumberAndCalendarDayNumber(lifepath, calendarDayNumber)
            .map(CompatibilityMatrix::getCompatibilityLabel)
            .orElse(null);
    }

    /**
     * Placeholder export method: left here for legacy support or future override.
     * Real export logic now lives in CalendarExportService.
     */
    public byte[] exportCalendar(Long userId, int year) {
        return new byte[0]; // Not used; prefer delegation
    }

    /**
     * Saves a user-created calendar day entry manually.
     * Validation logic can be added later (e.g. no duplicate dates).
     */
    public CalendarDay saveCalendarDay(CalendarDay day) {
        return calendarDayDao.save(day);
    }

    /**
     * Returns all entries in the compatibility matrix — helpful for admin or UI editors.
     */
    public List<CompatibilityMatrix> getCompatibilityMatrix() {
        return compatibilityMatrixDao.findAll();
    }

    /**
     * Saves a new matrix entry defining lifepath-to-day compatibility.
     */
    public CompatibilityMatrix saveMatrixEntry(CompatibilityMatrix entry) {
        Long labelId = entry.getCompatibilityLabel().getLabelId();
        CompatibilityLabel label = compatibilityLabelDao.findById(labelId)
            .orElseThrow(() -> new ResourceNotFoundException("Label not found with ID: " + labelId));

        entry.setCompatibilityLabel(label); // Assign managed entity

        return compatibilityMatrixDao.save(entry);
    }

    /**
     * Deletes a specific matrix entry by ID.
     */
    public void deleteMatrixEntry(Long id) {
        compatibilityMatrixDao.deleteById(id);
    }

    /**
     * Saves a new symbolic label (title, description, match type).
     */
    public CompatibilityLabel saveLabel(CompatibilityLabel label) {
        return compatibilityLabelDao.save(label);
    }

    /**
     * Updates a label’s content. Derives emoji-based symbol for display.
     */
    public CompatibilityLabel updateLabel(Long id, CompatibilityLabel update) {
        CompatibilityLabel existing = compatibilityLabelDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Label not found with ID: " + id));

        existing.setDescription(update.getDescription());
        existing.setTitle(update.getTitle());
        existing.setMatchType(update.getMatchType());

        // Optional symbol derivation for display or UI tagging
        String derivedSymbol = getSymbolForMatchType(update.getMatchType());
        System.out.println("Derived symbol: " + derivedSymbol); // Debug/logging only

        return compatibilityLabelDao.save(existing);
    }

    /**
     * Returns a symbolic tag for the given match type.
     * Can be used for CSV, PDF, or UI annotation.
     */
    private String getSymbolForMatchType(String matchType) {
        switch (matchType) {
            case "Natural Match":
                return "Sunny ☀️";
            case "Compatible":
                return "Cloudy ⛅";
            case "Challenge":
                return "Caution ⚠️";
            default:
                return "Unknown ❓";
        }
    }
    
    /**
     * Retrieves a CompatibilityLabel by its unique ID.
     * Returns null if no label is found with the given ID.
     *
     * @param id the ID of the label to retrieve
     * @return the CompatibilityLabel if found, otherwise null
     */
    public CompatibilityLabel getLabelById(Long id) {
        // Attempt to find the label by ID; return it if present, otherwise return null
        return compatibilityLabelDao.findById(id).orElse(null);
    }

    /**
     * Deletes a CompatibilityLabel by its unique ID.
     * If the ID does not exist, no action is taken.
     *
     * @param id the ID of the label to delete
     */
    public void deleteLabel(Long id) {
        // Remove the label from the database using its ID
        compatibilityLabelDao.deleteById(id);
    }
}