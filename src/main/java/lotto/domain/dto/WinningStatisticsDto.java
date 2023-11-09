package lotto.domain.dto;

public record WinningStatisticsDto(
        int countOfFifthPlace,
        int countOfFourthPlace,
        int countOfThirdPlace,
        int countOfSecondPlace,
        int countOfFirstPlace,
        double rateOrReturn
) {
}
