package numerology.calendar.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class UserProfile {
	// Primary key for the UserProfile entity
    @Id
    // Auto-generates the user ID using the database's identity strategy (e.g., auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // Stores the user's full name (used for numerology calculations)
    private String fullName;

    // Stores the user's birth date (used to derive lifepath number)
    private LocalDate birthDate;

    // Stores the calculated lifepath number based on birth date
    private Integer lifepathNumber;

    // One user can have many CalendarDay entries
    // 'mappedBy' indicates that the CalendarDay entity owns the relationship via its 'userProfile' field
    // 'cascade = CascadeType.ALL' ensures that calendar days are persisted, updated, or deleted along with the user
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<CalendarDay> calendarDays;
}
