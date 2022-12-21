package gerador.propostas.api.repository;

import gerador.propostas.api.repository.entity.AtuacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtuacaoRepository extends JpaRepository<AtuacaoEntity, Long> {

}
