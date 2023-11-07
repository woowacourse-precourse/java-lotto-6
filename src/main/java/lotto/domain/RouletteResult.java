package lotto.domain;

import java.util.Arrays;

public enum RouletteResult {
    FAILURE(0, 0, false),
    THREE_SAME_WINNING_NUMBER(3, 5000, false),
    FOUR_SAME_WINNING_NUMBER(4, 50000, false),
    FIVE_SAME_WINNING_NUMBER( 5, 1500000, false),
    FIVE_AND_BONUS_SAME_WINNING_NUMBER(5, 3000000, true),
    SIX_SAME_WINNING_NUMBER(6, 200000000, false);

    private final int count;
    private final int price;
    private final boolean isBonusNumber;

    RouletteResult(int count, int price, boolean isBonusNumber) {
        this.count = count;
        this.price = price;
        this.isBonusNumber = isBonusNumber;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public static RouletteResult findLottoCompensation(int count, boolean isBonusNumber) {
        if (!isBonusNumber || count != 5) {
            return Arrays.stream(values())
                    .filter(rouletteCompensation -> rouletteCompensation.getCount() == count)
                    .findFirst().orElse(FAILURE);
        }
        return FIVE_AND_BONUS_SAME_WINNING_NUMBER;
    }
}
