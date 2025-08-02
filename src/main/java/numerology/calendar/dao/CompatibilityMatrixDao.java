package numerology.calendar.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import numerology.calendar.entity.CompatibilityMatrix;

public interface CompatibilityMatrixDao extends JpaRepository<CompatibilityMatrix, Long> {

    // Look up a compatibility matrix entry based on lifepath number and symbolic calendar day
    Optional<CompatibilityMatrix> findByLifepathNumberAndCalendarDayNumber(int lifepath, int calendarDayNumber);
}
