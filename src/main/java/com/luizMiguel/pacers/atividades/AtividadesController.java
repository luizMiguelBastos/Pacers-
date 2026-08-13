package com.luizMiguel.pacers.atividades;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividades")
public class AtividadesController {

    public AtividadesService atividadesService;

    public AtividadesController(AtividadesService atividadesService){
        this.atividadesService = atividadesService;
    }

    @PostMapping("/")
    public ResponseEntity create (@RequestBody Atividades novaAtividade){
        Atividades atividadeCriada = atividadesService.criarAtividades(novaAtividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividadeCriada);
    }






}
