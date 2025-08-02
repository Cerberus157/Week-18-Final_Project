package numerology.calendar.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class UserRequestDto {

	// Ensures the full name is not blank; provides a custom validation message
    @NotBlank(message = "Full name is required")
    private String fullName;

    // Ensures the birthdate is not null and must be a date in the past
    @NotNull(message = "Birthdate must be provided")
    @Past(message = "Birthdate must be in the past")
    private LocalDate birthDate;

    // ✅ Default constructor required for deserialization and framework usage
    public UserRequestDto() {}

    // ✅ Parameterized constructor for manual instantiation
    public UserRequestDto(String fullName, LocalDate birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    // ✅ Getters & Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

