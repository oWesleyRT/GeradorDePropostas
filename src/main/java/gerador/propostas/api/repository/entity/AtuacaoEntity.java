package gerador.propostas.api.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Table(name = "atuacao")
@Entity(name = "atuacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtuacaoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean ativo;

    private String nome;

    @ManyToMany
    @JoinTable(name = "PROPOSTA_ATUACAO", joinColumns = @JoinColumn(name = "atuacao_id"),
            inverseJoinColumns = @JoinColumn(name = "proposta_id"))
    private List<PropostaEntity> propostaEntity;

    @Column(name ="valorintegral")
    private double valorIntegral;

    @Column(name ="valorcomdesconto")
    private double valorComDesconto;

}
