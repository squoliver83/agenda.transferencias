package pratica.avaliacao.agenda.transferencias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
