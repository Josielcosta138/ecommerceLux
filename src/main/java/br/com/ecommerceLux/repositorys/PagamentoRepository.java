package br.com.ecommerceLux.repositorys;

import br.com.ecommerceLux.entitys.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
