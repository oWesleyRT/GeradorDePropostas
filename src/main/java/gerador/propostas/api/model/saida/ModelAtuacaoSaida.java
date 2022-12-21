package gerador.propostas.api.model.saida;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelAtuacaoSaida{

    Long id;
    @NotBlank
    String nome;

    @NotNull
    @Positive
    double valorIntegral;

    @NotNull
    @Positive
    double valorComDesconto;

}