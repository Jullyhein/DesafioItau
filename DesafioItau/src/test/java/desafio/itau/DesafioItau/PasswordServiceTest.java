package desafio.itau.Desafioltau;

import desafio.password.repository.PasswordRepository;
import desafio.password.service.PasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PasswordServiceTest {

    @Mock
    private PasswordRepository repository; // Cria o banco "fake" (Mock)

    @InjectMocks
    private PasswordService service; // Cria o service injetando o banco fake nele

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        org.mockito.Mockito.doAnswer(invocation -> {
            return invocation.getArgument(0);
        }).when(repository).save(org.mockito.ArgumentMatchers.any());
    }

    @Test
    @DisplayName("Deve retornar TRUE para uma senha válida")
    void shouldReturnTrueForValidPassword() {
        assertTrue(service.isValid("AbTp9!fok"));
        assertTrue(service.isValid("Ps2@fghjk"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "AbTp9!foA",  // Repete o 'A'
            "AbTp9!foo",  // Repete o 'o'
            "password!",  // Falta maiúscula e dígito
            "AbTp9!f",    // Menos de 9 caracteres
            "AbTp9 !fok"  // Contém espaço
    })
    @DisplayName("Deve retornar FALSE para senhas inválidas")
    void shouldReturnFalseForInvalidPasswords(String invalidPassword) {
        assertFalse(service.isValid(invalidPassword));
    }
}