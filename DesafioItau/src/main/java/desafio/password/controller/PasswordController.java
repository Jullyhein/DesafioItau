package desafio.password.controller;

import desafio.password.dto.PasswordRequest;
import desafio.password.dto.PasswordResponse;
import desafio.password.service.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/password")
public class PasswordController {

    private static final Logger log = LoggerFactory.getLogger(PasswordController.class);
    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
        log.info(">>>> PasswordController carregado com sucesso! <<<<");
    }

    @GetMapping("/hello")
    public String goHorse() {
        log.info("Recebendo chamada na rota /hello");
        return "Olá mundo.";
    }

    @PostMapping(value = "/validate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PasswordResponse> validate(@RequestBody PasswordRequest request) {
        boolean valid = service.isValid(request.password());

        String message = valid ? "Senha válida: true" : "Senha inválida: false";

        return ResponseEntity.ok(new PasswordResponse(message, valid));
    }
}