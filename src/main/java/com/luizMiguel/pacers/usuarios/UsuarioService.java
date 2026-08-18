package com.luizMiguel.pacers.usuarios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario (Usuario novoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(novoUsuario.getUsername());

        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("Esse username ja esta em uso, tente outro!");
        }

        String senhaPura = novoUsuario.getSenha();
        String senhaCriptografada = BCrypt.hashpw(senhaPura, BCrypt.gensalt());
        novoUsuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(novoUsuario);
    }


    public String fazerLogin (String username, String senhaDigitada) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);

        if (usuarioOptional.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }

        Usuario usuarioDoBanco = usuarioOptional.get();
        boolean senhaCorreta = BCrypt.checkpw(senhaDigitada, usuarioDoBanco.getSenha());

        if (!senhaCorreta) {
            throw new IllegalArgumentException("Senha incorreta!");
        }

        String novoToken = UUID.randomUUID().toString();

        usuarioDoBanco.setTokenDeAcesso(novoToken);
        usuarioRepository.save(usuarioDoBanco);

        return novoToken;
    }

}
