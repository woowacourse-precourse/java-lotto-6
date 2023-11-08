package lotto.domain.event;

import java.util.List;
import lotto.domain.event.Event;

public record Yieldcalculationcompleted(List<String> allRankResults, double profitRate) implements Event {
}
