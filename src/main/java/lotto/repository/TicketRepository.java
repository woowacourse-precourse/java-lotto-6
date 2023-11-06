package lotto.repository;

import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public interface TicketRepository {

    Ticket purchase(Ticket ticket);

    Optional<Ticket> findById(Long id);

    Optional<Ticket> findByNumbers(Lotto numbers);

    List<Ticket> findAll();

}
