package lotto.domain.event.input;

import lotto.domain.event.Event;

public record LottoInputRequested(Lotto lotto, lotto.domain.event.output.TicketsCreated ticketsCreated) implements Event {
}
