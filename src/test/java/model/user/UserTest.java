package model.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static final String USERNAME = "Will2023";
    private static final String FIRST_NAME = "William";
    private static final String LAST_NAME = "Thompson";
    private static final String EMAIL = "fakeEmail@gmail.com";
    private static final String PASSWORD = "123456789";

    User underTest;

    @BeforeEach
    public void setUp() {
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
    }

    //Test Cases for Instantiation of the User Class.
    @Test
    public void shouldInstantiateUserClass() {
        assertNotNull(underTest);
    }

    //Test Cases for Getters & Setters
    @Test
    public void testGettersAndSetters() {
        assertEquals("Will2023", underTest.getUsername());
        assertEquals("William", underTest.getFirstName());
        assertEquals("Thompson", underTest.getLastName());
        assertEquals("fakeEmail@gmail.com", underTest.getEmail());
        assertEquals("123456789", underTest.getPassword());

        underTest.setUsername("NewUsername");
        underTest.setFirstName("Jane");
        underTest.setLastName("Doe");
        underTest.setEmail("");
        underTest.setPassword("newPassword");
        assertEquals("NewUsername", underTest.getUsername());
        assertEquals("Jane", underTest.getFirstName());
        assertEquals("Doe", underTest.getLastName());
        assertEquals("", underTest.getEmail());
        assertEquals("newPassword", underTest.getPassword());
    }

    //Test Cases for User Creation
    @Test
    public void testValidUserCreation() {
        assertNotNull(underTest);
    }

    @Test
    public void givenInvalidUserDetails_whenCreatingUser_thenThrowsException() {
       assertThrows(IllegalArgumentException.class, () ->
               underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, "invalid_email", PASSWORD)
       );
    }

    //Test Cases for UserName
    @Test
    public void testValidUserName() {
        underTest = new User("ValidUsername12", FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
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
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setUsername("")
        );
    }

    //Test Cases for First Name
    @Test
    public void testValidFirstName() {
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
        underTest.setFirstName("ValidFirstName");
        assertEquals("ValidFirstName", underTest.getFirstName());
    }

    @Test
    public void givenInvalidFirstName_whenSetFirstName_thenThrowException() {
    //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setFirstName("invalidFirstName@#$%^&*()_+")
        );
    }

    @Test
    public void whenFirstNameIsBlank_thenThrowException() {
    //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
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
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
        underTest.setLastName("ValidLastName");
        assertEquals("ValidLastName", underTest.getLastName());
    }

    @Test
    public void givenInvalidLastName_whenSetLastName_thenThrowException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () ->
                underTest.setLastName("invalidLastName@#$%^&*()_+")
        );
    }

    @Test
    public void whenLastNameIsBlank_thenThrowException() {
        //  If an error, specifically an "IllegalArgumentException", is not thrown, then the test case fails.
        underTest = new User(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD);
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
//    @Test
//    public void testValidEmail() {
        // Todo: Implement test
//    }

//    @Test
//    public void testInvalidEmail() {
        // Todo: Implement test
//    }

//    @Test
//    public void givenInvalidEmail_whenSettingEmail_thenThrowsException() {
        // Todo: Implement test
//    }




    //Test Cases for Password
//    @Test
//    public void testValidPassword() {
        // Todo: Implement test
//    }

//    @Test
//    public void testInvalidPassword() {
        // Todo: Implement test
//    }

//    @Test
//    public void givenInvalidPassword_whenSettingPassword_thenThrowsException() {
        // Todo: Implement test
//    }






    //Test Cases for Equality
//    @Test
//    public void testEquality() {
        //Todo: Implement test
//    }





    //Test Cases for toString
//    @Test
//    public void testToString() {
        // Todo: Implement test
//    }




    //Test Cases for HashCode
//    @Test
//    public void testHashCode() {
        //Todo: Implement test
//    }

}
