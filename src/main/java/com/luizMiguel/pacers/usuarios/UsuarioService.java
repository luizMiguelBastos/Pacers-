package com.luizMiguel.pacers.usuarios;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario (Usuario novoUsuario) {

        Optional<Usuario> usuaroExistente = usuarioRepository.findByUsername(novoUsuario.getUsername());

        if (usuaroExistente.isPresent()) {
            throw new IllegalArgumentException("Esse username ja esta em uso, tente outro!");
        }
        return usuarioRepository.save(novoUsuario);
    }
}
