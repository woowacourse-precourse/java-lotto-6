package lotto.dto;

import java.util.Map;

public record StatisticsResult(Map<String, Integer> prizeCount, long prizeMoney, int payment) {
}
