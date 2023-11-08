package lotto.service.dto;

public record LotteryResultDto(
        String ranking,
        int rankingMatches,
        int rankingAmount,
        int counts
) {
}
