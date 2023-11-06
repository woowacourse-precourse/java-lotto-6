package lotto.dto;

public record RankingDto(
        String rankingNumber,
        int matchCount,
        int reward,
        int count) {
}
