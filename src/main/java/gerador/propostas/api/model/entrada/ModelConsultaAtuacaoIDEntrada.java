package gerador.propostas.api.model.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelConsultaAtuacaoIDEntrada {

    @NotNull
    List<Long> idServicosSelecionados;

}
