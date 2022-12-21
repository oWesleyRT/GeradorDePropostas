package gerador.propostas.api.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Table(name = "Proposta")
@Entity(name = "Proposta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome")
    private String nome;

    @Column(name = "listaatuacaoids")
    private List<Long> listaAtuacaoIds;



    @ManyToMany(mappedBy = "propostaEntity")
    private List<AtuacaoEntity> listaAtuacao;

    @Column(name ="valorintegral")
    private double valorIntegral;

    @Column(name ="valorcomdesconto")
    private double valorComDesconto;

    public void SomarValorIntegral(Double valor) {
        this.valorIntegral += valor;
    }

    public void SomarValorComDesconto(Double valor) {
        this.valorComDesconto += valor;
    }

//    public double getValorIntegral() {
//        double total = 0;
//        for (var atuacao : listaAtuacao){
//            total += atuacao.getValorIntegral();
//        }
//        return total;
//    }
//
//    public double getValorComDesconto() {
//        double total = 0;
//        for (var atuacao : listaAtuacao){
//            total += atuacao.getValorComDesconto();
//        }
//        return total;
//    }
}
