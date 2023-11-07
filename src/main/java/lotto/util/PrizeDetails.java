package lotto.util;

public enum PrizeDetails {
    FIRST_PRIZE(6, 0, 1),
    SECOND_PRIZE(5, 1, 2),
    THIRD_PRIZE(5, 0, 3),
    FOURTH_PRIZE(4, 0, 4),
    FIFTH_PRIZE(3, 0, 5);

    private final Integer countOfLottoWinning;
    private final Integer countOfBonusWinning;
    private final Integer prize;

    PrizeDetails(Integer countOfLottoWinning, Integer countOfBonusWinning, Integer prize) {
        this.countOfLottoWinning = countOfLottoWinning;
        this.countOfBonusWinning = countOfBonusWinning;
        this.prize = prize;
    }

    public static Integer getPrize(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber) {
        for (PrizeDetails prizeDetail : PrizeDetails.values()) {
            if (prizeDetail.countOfLottoWinning.equals(countOfMatchedLottoNumbers) &&
                    prizeDetail.countOfBonusWinning.equals(countOfMatchedBonusNumber)) {
                return prizeDetail.prize;
            }
        }
        return 0;
    }
}
