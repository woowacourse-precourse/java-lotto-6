package lotto.dto.output;

public record PrizeStatisticsDto(
        int firstMatchCount,
        int secondMatchCount,
        int thirdMatchCount,
        int fourthMatchCount,
        int fifthMatchCount,
        double prizeOfRate
) {
}
