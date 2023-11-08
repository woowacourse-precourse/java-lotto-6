package lotto.domain.event.output;

import java.util.List;
import lotto.domain.event.Event;
import lotto.domain.event.input.Lotto;

public record TicketsCreated(List<Lotto> lottos) implements Event {

}
