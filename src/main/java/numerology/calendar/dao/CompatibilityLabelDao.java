package numerology.calendar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import numerology.calendar.entity.CompatibilityLabel;

public interface CompatibilityLabelDao extends JpaRepository<CompatibilityLabel, Long> {
    // Standard CRUD operations provided by JpaRepository
    // You can extend this later with custom queries (e.g., findByMatchType)
}
