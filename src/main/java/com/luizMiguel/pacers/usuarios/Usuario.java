package com.luizMiguel.pacers.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity (name = "tb_usuario")
public class Usuario {

    private String tokenDeAcesso;
    private String nome;
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String senha;

    @CreationTimestamp
    private LocalDateTime criadoEm;
}
