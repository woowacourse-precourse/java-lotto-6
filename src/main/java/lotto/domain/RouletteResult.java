package lotto.domain;

import java.util.Arrays;

public enum RouletteResult {
    FAILURE("꽝",0, 0, false),
    THREE_SAME_WINNING_NUMBER("3개 일치 (5,000원)", 3, 5000, false),
    FOUR_SAME_WINNING_NUMBER("4개 일치 (50,000원)", 4, 50000, false),
    FIVE_SAME_WINNING_NUMBER( "5개 일치 (1,500,000원)",5, 1500000, false),
    FIVE_AND_BONUS_SAME_WINNING_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 3000000, true),
    SIX_SAME_WINNING_NUMBER("6개 일치 (2,000,000,000원)", 6, 200000000, false);

    private final String message;
    private final int count;
    private final int price;
    private final boolean isBonusNumber;

    RouletteResult(String message, int count, int price, boolean isBonusNumber) {
        this.message = message;
        this.count = count;
        this.price = price;
        this.isBonusNumber = isBonusNumber;
    }

    public static RouletteResult findLottoCompensation(int count, boolean isBonusNumber) {
        if (!isBonusNumber || count != 5) {
            return Arrays.stream(values())
                    .filter(rouletteCompensation -> rouletteCompensation.getCount() == count)
                    .findFirst().orElse(FAILURE);
        }
        return FIVE_AND_BONUS_SAME_WINNING_NUMBER;
    }

    public String getMessage() {
        return message;
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
}
