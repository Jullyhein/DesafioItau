package desafio.password.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "th_password_history")
public class PasswordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private boolean isValid;
    private LocalDateTime createdAt;

    public PasswordEntity(){}

    public PasswordEntity(String password, boolean isValid){
        this.password = password;
        this.isValid = isValid;
    }

}
