package gerador.propostas.api.service;

import gerador.propostas.api.model.entrada.ModelAtuacaoEntrada;
import gerador.propostas.api.model.entrada.ModelAtualizarAtuacaoEntrada;
import gerador.propostas.api.model.entrada.ModelConsultaAtuacaoIDEntrada;
import gerador.propostas.api.model.saida.ModelAtuacaoSaida;
import gerador.propostas.api.repository.AtuacaoRepository;
import gerador.propostas.api.repository.entity.AtuacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtuacaoService {

    @Autowired
    private AtuacaoRepository atuacaoRepository;

    public ModelAtuacaoSaida cadastrar(ModelAtuacaoEntrada modelAtuacaoEntrada) {

        AtuacaoEntity atuacaoEntity = new AtuacaoEntity();
        atuacaoEntity.setNome(modelAtuacaoEntrada.getNome());
        atuacaoEntity.setValorIntegral(modelAtuacaoEntrada.getValorIntegral());
        atuacaoEntity.setValorComDesconto(modelAtuacaoEntrada.getValorComDesconto());
        atuacaoEntity.setAtivo(true);

        atuacaoEntity = atuacaoRepository.save(atuacaoEntity);

        ModelAtuacaoSaida modelAtuacaoSaida = new ModelAtuacaoSaida();
        modelAtuacaoSaida.setId(atuacaoEntity.getId());
        modelAtuacaoSaida.setNome(atuacaoEntity.getNome());
        modelAtuacaoSaida.setValorIntegral(atuacaoEntity.getValorIntegral());
        modelAtuacaoSaida.setValorComDesconto(atuacaoEntity.getValorComDesconto());

        return modelAtuacaoSaida;
    }

    public List<ModelAtuacaoSaida> listar() {
        List<ModelAtuacaoSaida> listAtuacaoSaida = new ArrayList<ModelAtuacaoSaida>();
        var listAtuacaoEntity = atuacaoRepository.findAll();

        for (var atuacao : listAtuacaoEntity){
            ModelAtuacaoSaida modelAtuacaoSaida = new ModelAtuacaoSaida();
            modelAtuacaoSaida.setId(atuacao.getId());
            modelAtuacaoSaida.setNome(atuacao.getNome());
            modelAtuacaoSaida.setValorIntegral(atuacao.getValorIntegral());
            modelAtuacaoSaida.setValorComDesconto(atuacao.getValorComDesconto());

            listAtuacaoSaida.add(modelAtuacaoSaida);
        }

        return listAtuacaoSaida;
    }

    public List<ModelAtuacaoSaida> ListarPorID(ModelConsultaAtuacaoIDEntrada modelConsultaAtuacaoIDEntrada) {
        List<ModelAtuacaoSaida> listAtuacaoSaida = new ArrayList<ModelAtuacaoSaida>();
        List<Long> listIds = modelConsultaAtuacaoIDEntrada.getIdServicosSelecionados();

        for (int i = 0 ; i < listIds.size() ; i++) {
            Long idDaList = listIds.get(i);
            AtuacaoEntity atuacaoEntity = new AtuacaoEntity();
            atuacaoEntity = atuacaoRepository.getReferenceById(idDaList);
            ModelAtuacaoSaida modelAtuacaoSaida = new ModelAtuacaoSaida();
            modelAtuacaoSaida.setId(atuacaoEntity.getId());
            modelAtuacaoSaida.setNome(atuacaoEntity.getNome());
            modelAtuacaoSaida.setValorIntegral(atuacaoEntity.getValorIntegral());
            modelAtuacaoSaida.setValorComDesconto(atuacaoEntity.getValorComDesconto());

            listAtuacaoSaida.add(modelAtuacaoSaida);
        }
        return listAtuacaoSaida;
    }

    public ModelAtuacaoSaida AtualizarAtuacao(ModelAtualizarAtuacaoEntrada modelAtualizarAtuacaoEntrada) {
        Long idSelecionado = modelAtualizarAtuacaoEntrada.getId();
        AtuacaoEntity atuacaoEntity = new AtuacaoEntity();
        ModelAtuacaoSaida modelAtuacaoSaida = new ModelAtuacaoSaida();
        atuacaoEntity = atuacaoRepository.getReferenceById(idSelecionado);

        if (modelAtualizarAtuacaoEntrada.getNome() != null){
            atuacaoEntity.setNome(modelAtualizarAtuacaoEntrada.getNome());
        }
        if (modelAtualizarAtuacaoEntrada.getValorIntegral() != 0) {
            atuacaoEntity.setValorIntegral(modelAtualizarAtuacaoEntrada.getValorIntegral());
        }
        if (modelAtualizarAtuacaoEntrada.getValorComDesconto() != 0) {
            atuacaoEntity.setValorComDesconto(modelAtualizarAtuacaoEntrada.getValorComDesconto());
        }

        atuacaoEntity = atuacaoRepository.save(atuacaoEntity);

        modelAtuacaoSaida.setId(atuacaoEntity.getId());
        modelAtuacaoSaida.setNome(atuacaoEntity.getNome());
        modelAtuacaoSaida.setValorIntegral(atuacaoEntity.getValorIntegral());
        modelAtuacaoSaida.setValorComDesconto(atuacaoEntity.getValorComDesconto());

        return modelAtuacaoSaida;
    }

    public String Inativar (Long id) {
        AtuacaoEntity atuacaoEntity = new AtuacaoEntity();
        atuacaoEntity = atuacaoRepository.getReferenceById(id);
        if (atuacaoEntity.getAtivo() != false) {
            atuacaoEntity.setAtivo(false);
            atuacaoEntity = atuacaoRepository.save(atuacaoEntity);
            return "O seguinte serviço foi desativado: " + atuacaoEntity.getNome();
        } else {
            return "O seguinte serviço selecionado, já está desativado: " + atuacaoEntity.getNome();
        }
    }

    public String Ativar(Long id) {
        AtuacaoEntity atuacaoEntity = new AtuacaoEntity();
        atuacaoEntity = atuacaoRepository.getReferenceById(id);
        if (atuacaoEntity.getAtivo() != true) {
            atuacaoEntity.setAtivo(true);
            atuacaoEntity = atuacaoRepository.save(atuacaoEntity);
            return "O seguinte serviço foi ativado: " + atuacaoEntity.getNome();
        } else {
            return "O seguinte serviço selecionado, já está ativado: " + atuacaoEntity.getNome();
        }
    }
}
