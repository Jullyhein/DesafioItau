package desafio.password.service;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class PasswordService {

    public boolean isValid(String password) {
        // Validação inicial: nulo, comprimento e espaços
        if (password == null || password.length() < 9 || password.contains(" ")) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        Set<Character> chars = new HashSet<>();

        String specials = "!@#$%^&*()-+";

        for (char c : password.toCharArray()) {
            // Verifica se o caractere já existe no Set (duplicidade)
            if (!chars.add(c)) {
                return false;
            }

            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (specials.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }

        // Retorna true apenas se todos os critérios forem atendidos
        return hasDigit && hasLower && hasUpper && hasSpecial;
    }
}