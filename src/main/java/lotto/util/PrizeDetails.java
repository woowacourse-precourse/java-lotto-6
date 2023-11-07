package lotto.util;

public enum PrizeDetails {

    FIRST_PRIZE(6, 0, 1),
    SECOND_PRIZE(5, 1, 2),
    THIRD_PRIZE(5, 0, 3),
    FOURTH_PRIZE(4, 0, 4),
    FIFTH_PRIZE(3, 0, 5);

    private final Integer countOfMatchedLottoNumbers;
    private final Integer countOfMatchedBonusNumber;
    private final Integer prize;

    PrizeDetails(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber, Integer prize) {
        this.countOfMatchedLottoNumbers = countOfMatchedLottoNumbers;
        this.countOfMatchedBonusNumber = countOfMatchedBonusNumber;
        this.prize = prize;
    }

    public static Integer getCountOfMatchedLottoNumbers(Integer prize) {
        for (PrizeDetails prizeDetail : PrizeDetails.values()) {
            if (prizeDetail.prize.equals(prize)) {
                return prizeDetail.countOfMatchedLottoNumbers;
            }
        }
        return 0;
    }

    public static Integer getCountOfMatchedBonusNumber(Integer prize) {
        for (PrizeDetails prizeDetail : PrizeDetails.values()) {
            if (prizeDetail.prize.equals(prize)) {
                return prizeDetail.countOfMatchedBonusNumber;
            }
        }
        return 0;
    }

    public Integer getPrize() {
        return this.prize;
    }

    public static Integer calculatePrize(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber) {
        for (PrizeDetails prizeDetail : PrizeDetails.values()) {
            if (prizeDetail.countOfMatchedLottoNumbers.equals(countOfMatchedLottoNumbers) &&
                    prizeDetail.countOfMatchedBonusNumber.equals(countOfMatchedBonusNumber)) {
                return prizeDetail.prize;
            }
        }
        return 0;
    }
}
