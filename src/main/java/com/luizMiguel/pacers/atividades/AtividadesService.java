package com.luizMiguel.pacers.atividades;

import org.springframework.stereotype.Service;

@Service
public class AtividadesService {

    private final AtividadesRepository atividadesRepository;

    public AtividadesService(AtividadesRepository atividadesRepository) {
        this.atividadesRepository = atividadesRepository;
    }

    public Atividades criarAtividades (Atividades novaAtividade){
        return atividadesRepository.save(novaAtividade);
    }



}
