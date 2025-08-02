package numerology.calendar.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CompatibilityLabel {
	// Primary key for the CompatibilityLabel entity
    @Id
    // Auto-generates the label ID using the database's identity strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    // Describes the type of match (e.g., "Natural Match", "Compatible", "Challenge")
    private String matchType;

    // Title or name of the label (e.g., "Spiritual Harmony", "Growth Opportunity")
    private String title;

    // Detailed description of the label's meaning and guidance
    // Limits the column length to 1024 characters to allow rich symbolic content
    @Column(length = 1024)
    private String description;
}
