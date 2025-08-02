 package numerology.calendar.entity;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data 
@Entity
 public class CompatibilityMatrix {
	// Primary key for the CompatibilityMatrix entity
    @Id
    // Auto-generates the matrix ID using the database's identity strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matrixId;

    // Lifepath number used in compatibility evaluation (e.g., 3, 7, 9)
    private int lifepathNumber;

    // Calendar day number used in compatibility evaluation (e.g., 1 to 9)
    private int calendarDayNumber;

    // Many matrix entries can share the same compatibility label
    // This sets up a many-to-one relationship with the CompatibilityLabel entity
    @ManyToOne
    // Specifies the foreign key column name and enforces non-null constraint
    @JoinColumn(name = "label_id", nullable = false)
    private CompatibilityLabel compatibilityLabel;
}
