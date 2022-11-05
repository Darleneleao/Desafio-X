package desafio.youx.cadastroclientesvendas.repository;

import desafio.youx.cadastroclientesvendas.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
