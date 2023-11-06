package lotto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public class MemoryTicketRepository implements TicketRepository {

    private static Map<Integer, Ticket> memory = new HashMap<>();
    private static Integer sequence = 0;

    @Override
    public Ticket purchase(Ticket ticket) {
        ticket.setId(++sequence);
        memory.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(memory.values());
    }

}
