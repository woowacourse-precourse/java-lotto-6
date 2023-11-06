package lotto.dto;

import java.util.Map;

public record RankResultDto(Map<RankPrizeDto, Integer> rank, double totalReturn) {
}
