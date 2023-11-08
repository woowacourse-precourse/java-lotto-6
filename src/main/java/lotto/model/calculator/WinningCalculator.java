package lotto.model.calculator;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;
import static lotto.util.AmountOfLotto.MINIMUM_AMOUNT_OF_LOTTO;
import static lotto.util.ExceptionMessage.INVALID_AMOUNT_OF_INVESTMENT;
import static lotto.util.ExceptionMessage.INVALID_RATE_OF_RESULT;
import static lotto.util.PrizeDetails.FIRST_PRIZE;
import static lotto.util.RateOfReturnDetails.ROUND_STANDARD;

import java.util.List;
import lotto.util.PrizeMoney;

/**
 * 당첨 내역을 계산하는데 필요한 여러가지 유틸을 제공한다.
 * 당첨번호, 보너스 번호와 비교하고, 유효한 수익률을 계산하는 기능을 포함한다.
 */
public class WinningCalculator {
    private static final Integer PERCENT = 100;
    private static final int CONTAIN_BONUS = 1;
    private static final int NOT_CONTAIN_BONUS = 0;
    private static final Long MINIMUM_RATE_OF_RESULT = 0L;
    private static final Long MAXIMUM_RATE_OF_RESULT =
            (PrizeMoney.getPrizeMoney(FIRST_PRIZE.getPrize()).longValue() / LOTTO_PRICE.getPrice().longValue()) * PERCENT;

    /**
     * 로또 번호와 당첨 번호를 비교하여 같은 값의 개수를 반환한다.
     *
     * @param lottoNumber 비교를 위한 로또 번호
     * @param winningNumber 비교를 위한 당첨 번호
     * @return 당첨 번호와 매치되는 번호의 개수
     */
    public static int comparingLottoAndWinningNumber(List<Integer> lottoNumber, List<Integer> winningNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumber::contains)
                .count();
    }

    /**
     * 로또 번호와 보너스 번호를 비교하여 동일 여부를 반환한다.
     *
     * @param lottoNumber 비교를 위한 로또 번호
     * @param bonusNumber 비교를 위한 당첨 번호
     * @return 로또 번호에 보너스 번호가 포함된다면 1을 반환한다; 포함되지 않는다면 0을 반환한다.
     */
    public static int comparingBonusAndWinningNumber(List<Integer> lottoNumber, Integer bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            return CONTAIN_BONUS;
        }
        return NOT_CONTAIN_BONUS;
    }

    /**
     * 투자금과 총 수익금을 비교하여 수익률을 계산한다.
     *
     * @param amountOfInvestment 로또를 구입하는데 사용한 투자금
     * @param totalPrizeMoney 총 상금
     * @return 퍼센트로 수익률을 계산하여 반환한다.
     * @throws IllegalArgumentException 투자금이 최소한의 로또 개수보다 적거나 같을 경우, 수익률이 유효한 범위를 벗어나는 경우
     */
    public static Double calculateRateOfReturn(Integer amountOfInvestment, Long totalPrizeMoney) {
        checkAmountOfInvestment(amountOfInvestment);

        Double rateOfReturn = (totalPrizeMoney.doubleValue() / amountOfInvestment.doubleValue()) * PERCENT;

        checkRangeOfRateOfReturn(rateOfReturn);

        return roundRateOfReturn(rateOfReturn);
    }

    private static void checkAmountOfInvestment(Integer amountOfInvestment) {
        if (amountOfInvestment <= MINIMUM_AMOUNT_OF_LOTTO.getPrice()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_OF_INVESTMENT.getMessage());
        }
    }

    private static void checkRangeOfRateOfReturn(Double rateOfReturn) {
        checkMinimum(rateOfReturn);
        checkMaximum(rateOfReturn);
    }

    private static void checkMinimum(Double rateOfReturn) {
        if (rateOfReturn < MINIMUM_RATE_OF_RESULT) {
            throw new IllegalArgumentException(INVALID_RATE_OF_RESULT.getMessage());
        }
    }

    private static void checkMaximum(Double rateOfReturn) {
        if (rateOfReturn > MAXIMUM_RATE_OF_RESULT) {
            throw new IllegalArgumentException(INVALID_RATE_OF_RESULT.getMessage());
        }
    }

    private static Double roundRateOfReturn(Double rateOfReturn) {
        return Math.round(rateOfReturn * ROUND_STANDARD.getDetail()) / ROUND_STANDARD.getDetail();
    }
}
