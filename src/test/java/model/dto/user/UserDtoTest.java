package model.dto.user;

import model.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDtoTest {

    @Test
    public void testUserDTO() {
        User user = new User();
        user.setId(1L);
        user.setUsername("UsernameDto1");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setEmail("Email@Hotmail.com");

        UserDto dto = new UserDto(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
        assertEquals(user.getEmail(), dto.getEmail());
    }

    @Test
    public void testEquals() {
        /* Testing if two instances of a class are the same is important because it helps ensure
           that the object's identity is consistent and maintained throughout the code.
           It is done using the assertEquals method to compare two instances and ensure that
           they are equal in terms of their fields. */
        User user = new User();
        user.setId(1L);
        user.setUsername("UsernameDto2");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setEmail("EMAIL@Gmail.com");

        UserDto dto = new UserDto(user);

        assertEquals(dto, dto);
        assertEquals(dto, new UserDto(user));
    }

    @Test
    void testHashCode() {
        UserDto userDto1 = new UserDto(1L, "UserName10", "John", "Doe", "fakeEmail@Gmail.com");
        UserDto userDto2 = new UserDto(1L, "UserName10", "John", "Doe", "fakeEmail@Gmail.com");
        UserDto userDto3 = new UserDto(2L, "UserName30", "Jane", "Doe", "fakeEmail2@Gmail.com");

        assertEquals(userDto1.hashCode(), userDto2.hashCode());
        assertNotEquals(userDto1.hashCode(), userDto3.hashCode());
    }


    @Test
    public void testToString() {
        UserDto dto = new UserDto(1L, "user1", "John", "Doe", "john.doe@example.com");

        String expected = "UserDto{id=1, username='user1', firstName='John', lastName='Doe', email='john.doe@example.com'}";
        assertEquals(expected, dto.toString());
    }

    @Test
    public void testToString_NullValues() {
        // With the addition of the UserDto constructor for testing Immutability,
        // this test is no longer valid.

        // UserDto dto = new UserDto(null, null, null, null, null);
        // String expected = "UserDto{id=null, username='null', firstName='null', lastName='null', email='null'}";
        // assertEquals(expected, dto.toString());
    }

    @Test
    public void testImmutability() {
        UserDto dto = new UserDto(1L, "user2", "John", "Doe", "john.doe@example.com");

        assertEquals(1L, dto.getId());
        assertEquals("user2", dto.getUsername());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("john.doe@example.com", dto.getEmail());
    }

    @Test
    public void testImmutability_NullValues() {
        // If the constructor of UserDto throws a NullPointerException, the test passes. Otherwise, the test fails.
        // This approach ensures that a user cannot create a UserDto with a null value.
        assertThrows(NullPointerException.class, () -> new UserDto(null, "username", "first", "last", "email"));
        assertThrows(NullPointerException.class, () -> new UserDto(1L, null, "first", "last", "email"));
        assertThrows(NullPointerException.class, () -> new UserDto(1L, "username", null, "last", "email"));
        assertThrows(NullPointerException.class, () -> new UserDto(1L, "username", "first", null, "email"));
        assertThrows(NullPointerException.class, () -> new UserDto(1L, "username", "first", "last", null));
    }

    @Test
    public void testCopyConstructor() {
        UserDto originalDto = new UserDto(1L, "johndoe", "John", "Doe", "johndoe@email.com");
        UserDto copiedDto = new UserDto(originalDto);

        assertEquals(originalDto, copiedDto);
        assertNotSame(originalDto, copiedDto);
    }

}
