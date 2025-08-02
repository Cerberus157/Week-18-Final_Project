package numerology.calendar.controller.error;

public class ResourceNotFoundException extends RuntimeException{

	// Ensures compatibility during serialization and deserialization
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ResourceNotFoundException with a specific error message.
     *
     * @param message the detail message explaining the exception
     */
    public ResourceNotFoundException(String message) {
        // Pass the message to the superclass (RuntimeException) constructor
        super(message);
    }
}
