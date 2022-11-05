package desafio.youx.cadastroclientesvendas.repository;

import desafio.youx.cadastroclientesvendas.domain.Cliente;
import desafio.youx.cadastroclientesvendas.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
