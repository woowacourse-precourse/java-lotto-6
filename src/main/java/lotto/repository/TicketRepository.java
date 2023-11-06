package lotto.repository;

import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public interface TicketRepository {

    Ticket purchase(Ticket ticket);

    List<Ticket> findAll();

}
