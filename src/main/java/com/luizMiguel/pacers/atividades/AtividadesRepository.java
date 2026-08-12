package com.luizMiguel.pacers.atividades;

import com.luizMiguel.pacers.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AtividadesRepository extends JpaRepository <Atividades, UUID>{
    Optional<Atividades> findById (UUID id);
}
