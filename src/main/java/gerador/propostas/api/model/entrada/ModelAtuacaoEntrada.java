package gerador.propostas.api.model.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelAtuacaoEntrada{

        @NotBlank
        String nome;

        @NotNull
        @Positive
        double valorIntegral;

        @NotNull
        @Positive
        double valorComDesconto;
}
