package com.luizMiguel.pacers.atividades;

import com.luizMiguel.pacers.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity (name = "tb_atividades")
@Data
public class Atividades {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private enum tipoAtividade {
        Bicicleta,
        Corrida,
        Caminhada
    }
    @Enumerated(EnumType.STRING)
    private tipoAtividade tipoAtividade;

    private Integer duracaoEmMinutos;
    private Double distanciaEmKm;
    private Double pace;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @PrePersist
    @PreUpdate
    public void calcularPaceAutomaticamente() {
        if (this.distanciaEmKm != null && this.distanciaEmKm > 0 && this.duracaoEmMinutos != null) {
            this.pace = this.duracaoEmMinutos / this.distanciaEmKm;
        } else {
            this.pace = 0.0;
        }
    }






}
