package desafio.password.service;

import desafio.password.model.PasswordEntity;
import desafio.password.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository repository;

    public boolean isValid(String password) {
        boolean isValid = validateLogic(password);

        repository.save(new PasswordEntity(password, isValid));

        return isValid;
    }

    private boolean validateLogic(String password) {
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

        return hasDigit && hasLower && hasUpper && hasSpecial;
    }
}