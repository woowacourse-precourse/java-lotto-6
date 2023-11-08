package lotto.domain.prize;

import java.util.Map;

public record LottoPrizeSummary(Map<Prize, Long> prizesCount) {
}
