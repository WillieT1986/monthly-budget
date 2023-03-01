package repository.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

//    @Autowired
//    private UserRepository repo;

    @Test
    public void testCreateUser() {
        // TODO: Create a new user and save it to the database
    }

    @Test
    public void testSaveAndRetrieveUser() {
        // TODO: Verify if a user can be saved into the repository and retrieve it back.
    }

    @Test
    public void testFindById() {
        // TODO: Verify if a user can be found by its id.
    }

    @Test
    public void testFindByUsername() {
        // TODO: Verify if a user can be found by its username.
    }

    @Test
    public void testFindByEmail() {
        // TODO: Verify if a user can be found by its email.
    }

    @Test
    public void testFindByUsernameOrEmail() {
        // TODO: Verify if a user can be found by its username or email.
    }

    @Test
    public void testFindByUsernameOrEmailAndPassword() {
        // TODO: Verify if a user can be found by its username or email and password.
    }

    @Test
    public void testUpdateUser() {
        // TODO: Verify if a user can be updated.
    }

    @Test
    public void testDeleteUser() {
        // TODO: Verify if a user can be deleted.
    }

    @Test
    public void testDeleteAllUsers() {
        // TODO: Verify if all users can be deleted.
    }

    @Test
    public void testPagination() {
        // TODO: Verify if pagination works.
    }

    @Test
    public void testSorting() {
        // TODO: Verify if sorting works.
    }

    @Test
    public void testCount() {
        // TODO: Verify if the count of users is correct.
    }

    @Test
    public void testExistsById() {
        // TODO: Verify if a user exists by its id.
    }




}
