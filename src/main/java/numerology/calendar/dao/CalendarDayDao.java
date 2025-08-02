package numerology.calendar.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import numerology.calendar.entity.CalendarDay;

public interface CalendarDayDao extends JpaRepository<CalendarDay, Long> {

    // Fetch all calendar days for a specific user by their userId
    List<CalendarDay> findByUserProfileUserId(Long userId);

    // Fetch calendar days for a user that fall within a specific date range (e.g., entire year)
    List<CalendarDay> findByUserProfileUserIdAndDateBetween(
        Long userId,
        LocalDate start,
        LocalDate end
    );
}

