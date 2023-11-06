package lotto.domain;

import java.util.List;

public interface TicketDispenser<T> {

    List<T> buyAutoCreatedTicket(int cost);
}
