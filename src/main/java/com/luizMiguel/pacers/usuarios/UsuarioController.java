package com.luizMiguel.pacers.usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Usuario novoUsuario) {
        try {
            Usuario usuarioCriado = usuarioService.criarUsuario(novoUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}










