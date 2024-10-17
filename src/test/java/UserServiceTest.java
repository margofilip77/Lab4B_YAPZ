import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User(1L, "Margo Fil", "fili@example.com");

        userService.createUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        User user = new User(1L, "Margo Fil", "fili@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        verify(userRepository, times(1)).findById(1L);
        assertEquals("Margo Fil", result.getName());
        assertEquals("fili@example.com", result.getEmail());
    }

    @Test
    void testUpdateUser() {
        User user = new User(1L, "Margo Fil", "fili@example.com");

        userService.updateUser(user);

        verify(userRepository, times(1)).save(user);
    }
}
