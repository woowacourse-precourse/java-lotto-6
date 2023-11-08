package lotto.dto;

import lotto.model.Ranking;

public record ResultItemDto(
        Ranking ranking,
        int numberOfMatch,
        boolean isBonusMatch,
        int prizeMoney,
        int count
) {
}
