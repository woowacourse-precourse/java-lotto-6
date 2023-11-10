package lotto.dto;

import java.util.Map;

public record StatisticsResult(Map<String, Integer> prizeCount, double revenue) {
}
