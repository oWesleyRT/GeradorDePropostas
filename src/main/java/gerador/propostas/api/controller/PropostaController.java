package gerador.propostas.api.controller;

import gerador.propostas.api.model.entrada.ModelPropostaEntrada;
import gerador.propostas.api.service.PropostaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    @Transactional
    @RequestMapping(value = "/cadastrar")
    public String CadastrarProposta (@RequestBody ModelPropostaEntrada modelPropostaEntrada){
        return propostaService.CadastrarProposta(modelPropostaEntrada);
    }
}
