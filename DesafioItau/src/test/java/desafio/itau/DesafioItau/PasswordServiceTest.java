package desafio.itau.Desafioltau; // Verifique se este nome de pacote bate com a sua pasta

import desafio.password.service.PasswordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {

    private final PasswordService service = new PasswordService();

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