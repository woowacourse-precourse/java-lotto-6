package lotto.domain.event.output;

import java.util.Map;
import lotto.domain.event.Event;
import lotto.domain.event.LottoRank;

public record TicketsEvaluateCompleted(Map<LottoRank, Integer> rankCount, TicketsCreated tickets) implements Event {

}
