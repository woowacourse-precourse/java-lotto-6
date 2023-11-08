package lotto.model;

import java.util.Arrays;

public enum Result {
    SAME6(6, 2_000_000_000),
    SAME5_BONUS(5.5, 30_000_000),
    SAME5(5, 1_500_000),
    SAME4(4, 50_000),
    SAME3(3, 5_000),
    NONE(0, 0);

    private final double countOfSameNumber;
    private final int returnMoney;

    Result(final double countOfSameNumber, final int returnMoney) {
        this.countOfSameNumber = countOfSameNumber;
        this.returnMoney = returnMoney;
    }

    public double getCountOfSameNumber() {
        return countOfSameNumber;
    }

    public int getReturnMoney() {
        return returnMoney;
    }

    public static Result getResult(final double count) {
        return Arrays.stream(values())
                .filter(result -> result.countOfSameNumber == count)
                .findAny()
                .orElse(NONE);
    }
}
