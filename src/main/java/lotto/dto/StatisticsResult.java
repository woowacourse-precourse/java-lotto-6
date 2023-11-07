package lotto.dto;

import java.util.Map;

public record StatisticsResult(Map<String, Integer> prizeCount, int prizeMoney, int payment) {
}
