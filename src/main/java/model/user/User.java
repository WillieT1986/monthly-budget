package model.user;

import jakarta.validation.constraints.NotBlank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";

    @NotBlank(message = "Username cannot be blank")
    String username;
    @NotBlank(message = "First Name cannot be blank")
    String first_name;
    @NotBlank(message = "Last Name cannot be blank")
    String last_name;
    @NotBlank(message = "Email cannot be blank")
    String email;
    @NotBlank(message = "Password cannot be blank")
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
        if (!isValidEmail(String.valueOf(email))) {
            throw new IllegalArgumentException("Invalid email");
        }
        boolean validatePassword = checkValidPassword(password);
        if (validatePassword) {
            if (!isValidPassword(password)) {
                throw new IllegalArgumentException("Invalid password");
            }
        }
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

   // USERNAME
    private boolean isValidUsername(String username) {
            return username != null && username.length() > 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Username can only contain letters and numbers");
        }
        this.username = username;
    }

    // FIRST NAME
    private boolean isValidFirstName(String firstName) {
        return firstName != null && firstName.length() > 0;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        if (!first_name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("First name can only contain letters");
        }
        this.first_name = first_name;
    }

    // LAST NAME
    private boolean isValidLastName(String lastName) {
        return lastName != null && lastName.length() > 0;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        if (!last_name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Last name can only contain letters");
        }
        this.last_name = last_name;
    }

    // EMAIL
    private boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }

//    public boolean checkValidEmail(String email) {
//        return isValidEmail(email);
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid E-Mail Address");
        }
        this.email = email;
    }

    // PASSWORD
    private boolean isValidPassword(String password) {
        return password != null && password.length() >= MIN_PASSWORD_LENGTH && password.matches(PASSWORD_REGEX);
    }

    public boolean checkValidPassword(String password) {
        return isValidPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character");
        }
        this.password = password;
    }

}
