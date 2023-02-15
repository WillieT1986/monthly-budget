package model.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static final String USERNAME = "Will2023";
    private static final String FIRST_NAME = "William";
    private static final String LAST_NAME = "Thompson";
    private static final String EMAIL = "fakeEmail@gmail.com";
    private static final String PASSWORD = "ABCDefg1!";

    User underTest;

    @BeforeEach
    public void setUp() {
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, new ArrayList<>());
    }

    //Test Cases for Instantiation of the User Class.
    @Test
    public void shouldInstantiateUserClass() {
        assertNotNull(underTest);
    }

    //Test Cases for Getters & Setters
    @Test
    public void testGettersAndSetters() {
        assertEquals(USERNAME, underTest.getUsername());
        assertEquals(FIRST_NAME, underTest.getFirstName());
        assertEquals(LAST_NAME, underTest.getLastName());
        assertEquals(EMAIL, underTest.getEmail());
        assertEquals(PASSWORD, underTest.getPassword());

        underTest.setUsername("NewUsername");
        underTest.setFirstName("Jane");
        underTest.setLastName("Doe");
        underTest.setEmail("fakeEmail22@gmail.com");
        underTest.setPassword("newPassword1!");
        assertEquals("NewUsername", underTest.getUsername());
        assertEquals("Jane", underTest.getFirstName());
        assertEquals("Doe", underTest.getLastName());
        assertEquals("fakeEmail22@gmail.com", underTest.getEmail());
        assertEquals("newPassword1!", underTest.getPassword());
    }

    //Test Cases for User Creation
    @Test
    public void testValidUserCreation() {
        assertNotNull(underTest);
    }

    @Test
    public void givenInvalidUserDetails_whenCreatingUser_thenThrowsException() {
       assertThrows(IllegalArgumentException.class, () ->
               underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, "invalid_email", PASSWORD, new ArrayList<>())
       );
    }

    //Test Cases for UserName
    @Test
    public void testValidUserName() {
        underTest.setUsername("ValidUsername125");
        assertEquals("ValidUsername125", underTest.getUsername());
    }

    @Test
    public void testInvalidUserNameSpecialChars() {
    //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setUsername("invalidUsername@#$%^&*()_+")
        );
    }

    @Test
    public void testInvalidUserNameSQLInjection() {
    //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setUsername("invalidUsername'; DROP TABLE users;")
        );
    }

    @Test
    public void whenUserNameIsBlank_thenThrowException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setUsername("")
        );
    }

    //Test Cases for First Name
    @Test
    public void testValidFirstName() {
        underTest.setFirstName("ValidFirstName");
        assertEquals("ValidFirstName", underTest.getFirstName());
    }

    @Test
    public void givenInvalidFirstName_whenSetFirstName_thenThrowException() {
    //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setFirstName("invalidFirstName@#$%^&*()_+")
        );
    }

    @Test
    public void whenFirstNameIsBlank_thenThrowException() {
    //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setFirstName("")
        );
    }

    @Test
    public void testInvalidFirstNameSQLInjection() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setFirstName("invalidFirstName'; DROP TABLE first_name;")
        );
    }

    // Test Cases for Last Name
    @Test
    public void testValidLastName() {
        underTest.setLastName("ValidLastName");
        assertEquals("ValidLastName", underTest.getLastName());
    }

    @Test
    public void givenInvalidLastName_whenSetLastName_thenThrowException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setLastName("invalidLastName@#$%^&*()_+")
        );
    }

    @Test
    public void whenLastNameIsBlank_thenThrowException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setLastName("")
        );
    }

    @Test
    public void testInvalidLastNameSQLInjection() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setLastName("invalidLastName'; DROP TABLE last_name;")
        );
    }

    //Test Cases for Email
    @Test
    public void testValidEmail() {
        underTest.setEmail("ValidEmail@GMail.com");
        assertEquals("ValidEmail@GMail.com", underTest.getEmail());
    }

    @Test
    public void givenInvalidEmail_whenSettingEmail_thenThrowsException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setEmail("invalidEmail")
        );
    }

    @Test
    public void whenEmailIsBlank_thenThrowException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setEmail("")
        );
    }

    @Test
    public void testInvalidEmailSQLInjection() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setEmail("invalidEmail'; DROP TABLE email;")
        );
    }

    @Test
    public void testValidateEmailRequirements() {
        assertTrue(underTest.checkValidEmail(underTest.email));
    }

    //Test Cases for Password
    @Test
    public void testValidatePasswordRequirements() {
        assertTrue(underTest.checkValidPassword(underTest.password));
    }

    @Test
    public void givenInvalidPassword_whenSettingPassword_thenThrowsException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setPassword("invalidPassword")
        );
    }

    @Test
    public void whenPasswordIsBlank_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setPassword("")
        );
    }

    @Test
    public void testPasswordAgainstSQLInjection() {
        // The first assertFalse checks if the password is considered invalid by the checkValidPassword method,
        // which should return false if it contains any malicious SQL statements.
        String password = "invalidPassword'; DROP TABLE password;";
        assertFalse(underTest.checkValidPassword(password));
        // The second assertThrows checks if the setPassword method throws an exception,
        // which it should do if it detects any malicious SQL statements in the password.
        assertThrows(IllegalArgumentException.class, () ->
            underTest.setPassword("invalidPassword'; DROP TABLE password;")
        );
    }

    // Test cases to verify that each username is unique and not equal to another user's username.
    // Ensures no duplicates and correct username assignment.
    @Test
    public void testUsernameUniqueness() {
        List<String> existingUsernames = new ArrayList<>();

        User user1 = new User("uniqueUsername1", "John", "Doe", "johndoe@email.com", "password123", existingUsernames);
        User user2 = new User("uniqueUsername2", "Jane", "Doe", "janedoe@email.com", "password456", existingUsernames);

        // Ensure the first user is created successfully
        assertNotNull(user1);

        // Attempt to create the second user with a different username
        assertNotNull(user2);

        // Now attempt to create a third user with the same username as the first user
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new User("uniqueUsername1", "Another", "User", "anotheruser@email.com", "password789", existingUsernames)
        );

        // Verify that an exception is thrown, indicating that the username is already taken
        assertEquals("Username already exists", exception.getMessage());
    }

    @Test
    public void testUserInequality() {
        User user1 = new User("uniqueUsername1", "John", "Doe", "email1@gmail.com", "passWORD1!", new ArrayList<>());
        User user2 = new User("uniqueUsername2", "John2", "Doe2", "email2@gmail.com", "passWORD2!", new ArrayList<>());
        assertNotEquals(user1, user2);
    }

    //Test Cases for ID
    @Test
    public void testAutoGeneratedUserId() {
        User user = new User("uniqueUsername", "John", "Doe", "fakeEmailYahoo1@gmail.com", "Password123!", new ArrayList<>());
        assertNotNull(user.getId());
    }

    @Test
    public void testEquals() {
        User user1 = new User("uniqueUsername1", "John", "Doe", EMAIL, "password123", new ArrayList<>());
        User user2 = new User("uniqueUsername2", "Jane", "Doe", EMAIL, "password456", new ArrayList<>());
        assertNotEquals(user1, user2);
    }

    @Test
    public void testHashCode() {
        User user1 = new User("uniqueUsername1", "John", "Doe", EMAIL, "password123", new ArrayList<>());
        User user2 = new User("uniqueUsername2", "Jane", "Doe", EMAIL, "password456", new ArrayList<>());
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "User{" +
                "id=" + underTest.getId() +
                ", username='" + underTest.getUsername() + '\'' +
                ", firstName='" + underTest.getFirstName() + '\'' +
                ", lastName='" + underTest.getLastName() + '\'' +
                ", email='" + underTest.getEmail() + '\'' +
                ", password='" + underTest.getPassword() + '\'' +
                '}';
        assertEquals(expected, underTest.toString());
    }

}
