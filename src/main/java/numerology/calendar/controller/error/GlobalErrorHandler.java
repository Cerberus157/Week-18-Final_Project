package numerology.calendar.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalErrorHandler {

	/**
     * Handles any uncaught exceptions that aren't specifically mapped.
     * Returns a generic 500 Internal Server Error response with the exception message.
     *
     * @param e the exception that was thrown
     * @return a ResponseEntity with status 500 and error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Respond with a 500 status and include the exception message in the response body
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + e.getMessage());
    }

    /**
     * Handles cases where an entity is not found in the database.
     * Returns a 404 Not Found response with a generic message.
     *
     * @param e the EntityNotFoundException that was thrown
     * @return a ResponseEntity with status 404 and a simple not-found message
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        // Respond with a 404 status and a fixed message indicating the entity was not found
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Entity not found.");
    }
}
