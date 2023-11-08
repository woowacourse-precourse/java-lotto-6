package lotto.domain;

import java.util.Map;
import lotto.InputException;

public class Money {
    private static final String RANGE_ERROR_MESSAGE = "1000 이상의 숫자만 입력 가능합니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "1000원 단위로만 구매가 가능합니다.";
    private static final int BASIC_UNIT = 1_000;

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
        return Reward.FIRST_PLACE.calculate(getCountOfRank(resultOfLottos, 1))
                + Reward.SECOND_PLACE.calculate(getCountOfRank(resultOfLottos, 2))
                + Reward.THIRD_PLACE.calculate(getCountOfRank(resultOfLottos, 3))
                + Reward.FOURTH_PLACE.calculate(getCountOfRank(resultOfLottos, 4))
                + Reward.FIFTH_PLACE.calculate(getCountOfRank(resultOfLottos, 5));
    }

    private int getCountOfRank(Map<Integer, Integer> resultOfLottos, int rank) {
        return resultOfLottos.getOrDefault(rank, 0);
    }

    private double roundResult(double result) {
        return Math.round(result * 10) / 10.0;
    }

    private void validateRange(long amount) {
        if (amount <= BASIC_UNIT) {
            throw new InputException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDivisibleBy1000(long amount) {
        if (amount % BASIC_UNIT != 0) {
            throw new InputException(DIVIDE_ERROR_MESSAGE);
        }
    }
}
