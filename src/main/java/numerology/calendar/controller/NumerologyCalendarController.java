package numerology.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import numerology.calendar.dto.UserRequestDto;
import numerology.calendar.entity.CalendarDay;
import numerology.calendar.entity.CompatibilityLabel;
import numerology.calendar.entity.CompatibilityMatrix;
import numerology.calendar.entity.UserProfile;
import numerology.calendar.service.CalendarExportService;
import numerology.calendar.service.NumerologyCalendarService;

@RestController
@RequestMapping("/numerology_calendar")
public class NumerologyCalendarController {

    @Autowired
    private NumerologyCalendarService calendarService;

    @Autowired
    private CalendarExportService exportService;

    /**
     * 🆕 Create a user profile from full name and birthdate.
     * Automatically calculates lifepath and generates a 365-day calendar.
     */
    @PostMapping("/users")
    public ResponseEntity<UserProfile> createUser(@Valid @RequestBody UserRequestDto requestDto) {
        UserProfile createdUser = calendarService.createUser(
            requestDto.getFullName(),
            requestDto.getBirthDate()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * 🎯 Generate full numerology calendar for a user and year.
     * Returns a list of CalendarDay entries with symbolic day numbers linked to user's lifepath.
     */
    @GetMapping("/{userId}/{year}")
    public ResponseEntity<List<CalendarDay>> generateCalendar(
            @PathVariable Long userId, @PathVariable int year) {
        List<CalendarDay> calendar = calendarService.generateCalendar(userId, year);
        return ResponseEntity.ok(calendar);
    }

    /**
     * 🧠 Fetch compatibility label for a given lifepath and day number.
     * Used to determine match strength, symbolic guidance, or affirmations.
     */
    @GetMapping("/compatibility/{lifepath}/{day}")
    public ResponseEntity<CompatibilityLabel> getCompatibility(
            @PathVariable int lifepath, @PathVariable int day) {
        CompatibilityLabel label = calendarService.getCompatibility(lifepath, day);
        return label != null ? ResponseEntity.ok(label) : ResponseEntity.notFound().build();
    }

    /**
     * 🧾 Export user's numerology calendar as a downloadable CSV file.
     * Each row includes date, symbolic day number, match type, title, and description.
     */
    @GetMapping("/{userId}/{year}/export")
    public ResponseEntity<byte[]> exportCalendar(
            @PathVariable Long userId, @PathVariable int year) {
        byte[] exportFile = exportService.exportCalendar(userId, year);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=calendar_export.csv")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(exportFile);
    }

    /**
     * ➕ Manually create a calendar day entry.
     * Allows user-defined or admin-generated entries outside automated generation logic.
     */
    @PostMapping("/day")
    public ResponseEntity<CalendarDay> createCalendarDay(@RequestBody CalendarDay newDay) {
        CalendarDay saved = calendarService.saveCalendarDay(newDay);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * 📊 Retrieve the full compatibility matrix.
     * Useful for reviewing all lifepath-to-day match pairings and symbolic mappings.
     */
    @GetMapping("/matrix")
    public ResponseEntity<List<CompatibilityMatrix>> getMatrix() {
        List<CompatibilityMatrix> matrix = calendarService.getCompatibilityMatrix();
        return ResponseEntity.ok(matrix);
    }

    /**
     * 🧬 Add a new compatibility matrix entry.
     * Used to define how a specific lifepath aligns with a calendar day number.
     */
    @PostMapping("/matrix")
    public ResponseEntity<CompatibilityMatrix> addMatrixEntry(@RequestBody CompatibilityMatrix entry) {
        CompatibilityMatrix saved = calendarService.saveMatrixEntry(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * ❌ Delete a compatibility matrix entry by ID.
     * Removes predefined match logic from the system for recalibration or maintenance.
     */
    @DeleteMapping("/matrix/{id}")
    public ResponseEntity<Void> deleteMatrixEntry(@PathVariable Long id) {
        calendarService.deleteMatrixEntry(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 🏷️ Create a new symbolic compatibility label.
     * Each label includes match type, title, and description for enriched day mapping.
     */
    @PostMapping("/label")
    public ResponseEntity<CompatibilityLabel> createLabel(@RequestBody CompatibilityLabel label) {
        CompatibilityLabel saved = calendarService.saveLabel(label);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * ✏️ Update an existing compatibility label by ID.
     * Allows editing match type and description to refine guidance and symbolism.
     */
    @PutMapping("/label/{id}")
    public ResponseEntity<CompatibilityLabel> updateLabel(
            @PathVariable Long id, @RequestBody CompatibilityLabel update) {
        CompatibilityLabel edited = calendarService.updateLabel(id, update);
        return ResponseEntity.ok(edited);
    }
    
    /** 
     * 🔍 Retrieve a compatibility label by ID.
     * Useful for viewing symbolic guidance, match type, and description.
     */
    @GetMapping("/label/{id}")
    public ResponseEntity<CompatibilityLabel> getLabelById(@PathVariable Long id) {
        CompatibilityLabel label = calendarService.getLabelById(id);
        return label != null ? ResponseEntity.ok(label) : ResponseEntity.notFound().build();
    }

    /** 
     * 🗑️ Delete a compatibility label by ID.
     * Removes symbolic guidance from the system for recalibration or cleanup.
     */
    @DeleteMapping("/label/{id}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        calendarService.deleteLabel(id);
        return ResponseEntity.noContent().build();
    }

}