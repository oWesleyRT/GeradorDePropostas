package gerador.propostas.api.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import gerador.propostas.api.model.entrada.ModelAtuacaoEntrada;
import gerador.propostas.api.model.entrada.ModelAtualizarAtuacaoEntrada;
import gerador.propostas.api.model.entrada.ModelConsultaAtuacaoIDEntrada;
import gerador.propostas.api.model.saida.ModelAtuacaoSaida;
import gerador.propostas.api.repository.AtuacaoRepository;
import gerador.propostas.api.service.AtuacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("atuacao")
public class AtuacaoController {

    @Autowired
    private AtuacaoService atuacaoService;

    @Autowired
    private AtuacaoRepository atuacaoRepository;

    @PostMapping
    @Transactional
    @RequestMapping(value = "/cadastrar")
    public ModelAtuacaoSaida Cadastrar(@RequestBody @Valid ModelAtuacaoEntrada modelAtuacaoEntrada) {
        ModelAtuacaoSaida modelAtuacaoSaida = atuacaoService.cadastrar(modelAtuacaoEntrada);
        return modelAtuacaoSaida;
    }

    @GetMapping
    @RequestMapping(value = "/listar")
    public List<ModelAtuacaoSaida> listar () {
        return atuacaoService.listar();
    }

    @GetMapping
    @RequestMapping(value = "/listar/id")
    public List<ModelAtuacaoSaida> ListarPorId (@RequestBody @Valid ModelConsultaAtuacaoIDEntrada modelConsultaAtuacaoIDEntrada) {
        return atuacaoService.ListarPorID(modelConsultaAtuacaoIDEntrada);
    }

    @PutMapping
    @Transactional
    @RequestMapping(value = "/atualizar")
    public ModelAtuacaoSaida Atualizar(@RequestBody @Valid ModelAtualizarAtuacaoEntrada modelAtualizarAtuacaoEntrada) {
        return atuacaoService.AtualizarAtuacao(modelAtualizarAtuacaoEntrada);
    }

    @DeleteMapping(value = "/inativar/{id}")
    @Transactional
    public String Inativar(@PathVariable @RequestBody Long id) {
        return atuacaoService.Inativar(id);
    }

    @PatchMapping
    @Transactional
    @RequestMapping(value = "/ativar/{id}")
    public String Ativar (@PathVariable @RequestBody Long id) {
        return atuacaoService.Ativar(id);
    }

}
