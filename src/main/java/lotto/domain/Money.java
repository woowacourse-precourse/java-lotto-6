package lotto.domain;

import java.util.Map;
import lotto.InputException;

public class Money {
    private static final String RANGE_ERROR_MESSAGE = "1000 이상의 숫자만 입력 가능합니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "1000원 단위로만 구매가 가능합니다.";

    private final long amount;

    public Money(long amount) {
        validateRange(amount);
        validateDivisibleBy1000(amount);
        this.amount = amount;
    }

    public int getDividedBy1000() {
        return (int) (amount / 1_000);
    }

    public double getProfitRate(Map<Integer, Integer> resultOfLottos) {
        double totalSum = getTotalSum(resultOfLottos);

        return roundResult(totalSum / amount * 100);
    }

    private long getTotalSum(Map<Integer, Integer> resultOfLottos) {
        int firstPlaceCount = resultOfLottos.getOrDefault(1, 0);
        int secondPlaceCount = resultOfLottos.getOrDefault(2, 0);
        int thirdPlaceCount = resultOfLottos.getOrDefault(3, 0);
        int fourthPlaceCount = resultOfLottos.getOrDefault(4, 0);
        int fifthPlaceCount = resultOfLottos.getOrDefault(5, 0);

        return Reward.FIRST_PLACE.calculate(firstPlaceCount)
                + Reward.SECOND_PLACE.calculate(secondPlaceCount)
                + Reward.THIRD_PLACE.calculate(thirdPlaceCount)
                + Reward.FOURTH_PLACE.calculate(fourthPlaceCount)
                + Reward.FIFTH_PLACE.calculate(fifthPlaceCount);
    }

    private double roundResult(double result) {
        return Math.round(result * 10) / 10.0;
    }

    private void validateRange(long amount) {
        if (amount <= 1_000) {
            throw new InputException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDivisibleBy1000(long amount) {
        if (amount % 1_000 != 0) {
            throw new InputException(DIVIDE_ERROR_MESSAGE);
        }
    }
}
