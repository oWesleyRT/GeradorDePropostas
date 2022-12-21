package gerador.propostas.api.service;

import gerador.propostas.api.model.entrada.ModelPropostaEntrada;
import gerador.propostas.api.repository.AtuacaoRepository;
import gerador.propostas.api.repository.PropostaRepository;
import gerador.propostas.api.repository.entity.AtuacaoEntity;
import gerador.propostas.api.repository.entity.PropostaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private AtuacaoRepository atuacaoRepository;
    private final PropostaRepository propostaRepository;

    @Autowired
    public PropostaService(AtuacaoRepository atuacaoRepository,
                           PropostaRepository propostaRepository) {
        this.atuacaoRepository = atuacaoRepository;
        this.propostaRepository = propostaRepository;
    }

    public File GerarPdf(PropostaEntity propostaEntity) {
        return new File("arquivoVazio.txt");
    }

    public String CadastrarProposta(ModelPropostaEntrada modelPropostaEntrada){
        PropostaEntity propostaEntity = new PropostaEntity();
        List<AtuacaoEntity> listaAtuacao = new ArrayList<>();
        List<Long> listaAtuacaoSelecionadas = new ArrayList<>();
        propostaEntity.setNome(modelPropostaEntrada.getNome());

        List<Long> idServicosSelecionados = new ArrayList<>();
        idServicosSelecionados = modelPropostaEntrada.getIdServicosSelecionados();

        for (int i = 0 ; i < idServicosSelecionados.size() ; i++) {
            AtuacaoEntity atuacaoEntity = new AtuacaoEntity();
            atuacaoEntity = atuacaoRepository.getReferenceById(idServicosSelecionados.get(i));
            listaAtuacao.add(atuacaoEntity);
            listaAtuacaoSelecionadas.add(atuacaoEntity.getId());
            propostaEntity.SomarValorIntegral(atuacaoEntity.getValorIntegral());
            propostaEntity.SomarValorComDesconto(atuacaoEntity.getValorComDesconto());
        }

//        propostaEntity.setListaAtuacaoIds(idServicosSelecionados);
//        implementar foreign key para poder salvar a lista dos serviços escolhidos
        propostaEntity.setListaAtuacao(listaAtuacao);
        propostaRepository.save(propostaEntity);
        //salvar no banco a propostaEntity

        return "Os serviços selecionados foram: " + listaAtuacaoSelecionadas + ". O valor integral é de R$"
                + propostaEntity.getValorIntegral() + ", enquanto o valor com desconto é de R$" +
                 propostaEntity.getValorComDesconto();
    }
}
