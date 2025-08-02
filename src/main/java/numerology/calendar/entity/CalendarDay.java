package numerology.calendar.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CalendarDay {
	// Primary key for the CalendarDay entity
    @Id
    // Auto-generates the ID using the database's identity column (e.g., auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarDayId;

    // Stores the actual calendar date (e.g., 2025-08-02)
    private LocalDate date;

    // Stores the symbolic numerology day number (e.g., 7 for spiritual alignment)
    private Integer calendarDayNumber;

    // Many CalendarDay entries can be associated with one UserProfile
    @ManyToOne
    // Specifies the foreign key column name in the CalendarDay table
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;
}
