package lotto.dto;

public record LottoResultDto(int firstPrizeCount, int secondPrizeCount, int thirdPrizeCount,
                             int fourthPrizeCount, int fifthPrizeCount, String profitRate) {
}
