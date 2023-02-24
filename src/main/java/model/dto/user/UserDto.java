package model.dto.user;

import model.user.User;

import java.util.Objects;

public final class UserDto {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;

    // This constructor is used to create a new UserDto object from an existing UserDto object.
    public UserDto(UserDto other) {
        this.id = other.id;
        this.username = other.username;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;
    }


    public UserDto(Long id, String username, String firstName, String lastName, String email) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.username = Objects.requireNonNull(username, "username must not be null");
        this.firstName = Objects.requireNonNull(firstName, "firstName must not be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserDto)) {
            return false;
        }
        return Objects.equals(id, ((UserDto) obj).id)
                && Objects.equals(username, ((UserDto) obj).username)
                && Objects.equals(firstName, ((UserDto) obj).firstName)
                && Objects.equals(lastName, ((UserDto) obj).lastName)
                && Objects.equals(email, ((UserDto) obj).email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
