package com.luizMiguel.pacers.atividades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.antlr.v4.runtime.misc.Interval;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Atividades {

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private enum atividade {
        Bicicleta,
        Corrida,
        Caminhada
    }

    private Interval duracao;
    private double distancia;
    private LocalDateTime criadoEm;






}
