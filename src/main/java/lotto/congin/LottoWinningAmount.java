package lotto.congin;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinningAmount {
    THREE(3,false,5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    BONUS_FIVE(5, true, 30000000),
    SIX(6,false, 2000000000);

    private final int winningNumber;
    private final Boolean isBonus;
    private final int winningAmount;

    LottoWinningAmount(int winningNumber,  Boolean isBonus, int winningAmount) {
        this.winningNumber = winningNumber;
        this.isBonus = isBonus;
        this.winningAmount = winningAmount;
    }

    public static Optional<LottoWinningAmount> getWinningAmount(int winningNumber, Boolean isBonus) {
        return Arrays.stream(LottoWinningAmount.values())
                .filter(amount -> amount.winningNumber == winningNumber && amount.isBonus == isBonus)
                .findAny();
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public Boolean getBonus() {
        return isBonus;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
