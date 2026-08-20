package com.luizMiguel.pacers.atividades;

import com.luizMiguel.pacers.security.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades")
public class AtividadesController {

    private final TokenService tokenService;

    public AtividadesService atividadesService;

    public AtividadesController(TokenService tokenService, AtividadesService atividadesService){
        this.tokenService = tokenService;
        this.atividadesService = atividadesService;
    }

    @PostMapping
    public ResponseEntity<String> criarAtividade(
            @RequestBody Atividades atividade,
            @RequestHeader("Authorization") String cabecalhoToken) {

        try {
            String tokenPuro = cabecalhoToken.replace("Bearer ", "");

            String idDoUsuarioLogado = tokenService.validarTokenEpegarId(tokenPuro);
            return ResponseEntity.ok("Atividade criada com sucesso! O ID do criador é: " + idDoUsuarioLogado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("Acesso negado: Token inválido ou expirado.");
        }
    }
}







