package lotto.util;

/**
 * 각 등수 별로 매치되어야 할 로또 번호의 개수에 관한 정보를 저장한다.
 */
public enum PrizeDetails {

    FIRST_PRIZE(6, 0, 1),
    SECOND_PRIZE(5, 1, 2),
    THIRD_PRIZE(5, 0, 3),
    FOURTH_PRIZE(4, 0, 4),
    FIFTH_PRIZE(3, 0, 5);

    private static final int NOT_MATCH = 0;

    private final Integer countOfMatchedLottoNumbers;
    private final Integer countOfMatchedBonusNumber;
    private final Integer prize;

    PrizeDetails(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber, Integer prize) {
        this.countOfMatchedLottoNumbers = countOfMatchedLottoNumbers;
        this.countOfMatchedBonusNumber = countOfMatchedBonusNumber;
        this.prize = prize;
    }

    /**
     * 특정 등수에 매치되어야 할 정답 번호를 반환한다.
     *
     * @param prize 등수
     * @return 매치되어야 하는 정답 번호의 개수
     */
    public static Integer getCountOfMatchedLottoNumbers(Integer prize) {
        for (PrizeDetails prizeDetail : PrizeDetails.values()) {
            if (prizeDetail.prize.equals(prize)) {
                return prizeDetail.countOfMatchedLottoNumbers;
            }
        }
        return 0;
    }

    public Integer getPrize() {
        return this.prize;
    }

    /**
     * 매치된 정답 번호, 보너스 번호의 개수가 주어진 경우 등수를 계산한다.
     *
     * @param countOfMatchedLottoNumbers 매치된 정답 번호의 개수
     * @param countOfMatchedBonusNumber 매치된 보너스 번호의 개수
     * @return 계산된 등수
     */
    public static Integer calculatePrize(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber) {
        for (PrizeDetails prizeDetail : PrizeDetails.values()) {
            if (prizeDetail.countOfMatchedLottoNumbers.equals(countOfMatchedLottoNumbers) &&
                    prizeDetail.countOfMatchedBonusNumber.equals(countOfMatchedBonusNumber)) {
                return prizeDetail.prize;
            }
        }
        return NOT_MATCH;
    }
}
