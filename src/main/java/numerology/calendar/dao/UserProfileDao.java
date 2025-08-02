package numerology.calendar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import numerology.calendar.entity.UserProfile;

public interface UserProfileDao extends JpaRepository<UserProfile, Long> {
    // Basic user lookup via JpaRepository (findById, save, delete, etc.)
    // Extend as needed, such as finding by birthdate or username if applicable
}
