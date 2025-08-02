package numerology.calendar.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numerology.calendar.dao.CalendarDayDao;
import numerology.calendar.entity.CalendarDay;
import numerology.calendar.entity.CompatibilityLabel;

@Service
public class CalendarExportService {

    // Access to calendar day records from the database
    @Autowired
    private CalendarDayDao calendarDayDao;

    // Reuse compatibility logic from the main service to avoid duplication
    @Autowired
    private NumerologyCalendarService calendarService;

    /**
     * Exports the calendar data for a specific user and year as a CSV byte stream.
     * The CSV includes date, symbolic day number, match type, title, and description.
     */
    public byte[] exportCalendar(Long userId, int year) {
        // Retrieve all calendar days for the specified user and year
        List<CalendarDay> calendar = calendarDayDao.findByUserProfileUserIdAndDateBetween(
            userId,
            LocalDate.of(year, 1, 1),
            LocalDate.of(year, 12, 31)
        );

        // Initialize CSV header row
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("Date,DayNumber,MatchType,Title,Description\n");

        // Populate each row of the CSV with calendar data and compatibility labels
        for (CalendarDay day : calendar) {
            CompatibilityLabel label = calendarService.getCompatibility(
                day.getUserProfile().getLifepathNumber(),
                day.getCalendarDayNumber()
            );

            // Append each data row, escaping commas where necessary
            csvBuilder.append(day.getDate()).append(",")
                      .append(day.getCalendarDayNumber()).append(",")
                      .append(label != null ? label.getMatchType() : "").append(",")
                      .append(label != null ? label.getTitle() : "").append(",")
                      .append(label != null ? label.getDescription().replace(",", " ") : "")
                      .append("\n");
        }

        // Convert CSV content into byte array for file download
        return csvBuilder.toString().getBytes(StandardCharsets.UTF_8);
    }
}