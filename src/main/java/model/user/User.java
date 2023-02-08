package model.user;

import jakarta.validation.constraints.NotBlank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final int MIN_PASSWORD_LENGTH = 8;
    @NotBlank(message = "Username cannot be blank")
    String username;
    @NotBlank(message = "First Name cannot be blank")
    String first_name;
    @NotBlank(message = "Last Name cannot be blank")
    String last_name;
    String email;
    String password;



    public User(String username, String first_name, String last_name, String email, String password) {
        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!isValidFirstName(first_name)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (!isValidLastName(last_name)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    private boolean isValidUsername(String username) {
            return username != null && username.length() > 0;
    }

    private boolean isValidFirstName(String firstName) {
        return firstName != null && firstName.length() > 0;
    }

    private boolean isValidLastName(String lastName) {
        return lastName != null && lastName.length() > 0;
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= MIN_PASSWORD_LENGTH;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Username can only contain letters and numbers");
        }
        this.username = username;
    }

    public void setFirstName(String first_name) {
        if (!first_name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("First name can only contain letters");
        }
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        if (!last_name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Last name can only contain letters");
        }
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
