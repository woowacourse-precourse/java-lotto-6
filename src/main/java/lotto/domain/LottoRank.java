package lotto.domain;


import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    ZERO(0, "0", (matchCount, isBonus) -> matchCount < 3),
    THREE(3, "5,000", (matchCount, isBonus) -> matchCount == 3),
    FOUR(4, "50,000", (matchCount, isBonus) -> matchCount == 4),
    FIVE(5, "1,500,000", (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    FIVE_BONUS(5, "30,000,000", (matchCount, isBonus) -> matchCount == 5 && isBonus),
    SIX(6, "2,000,000,000", (matchCount, isBonus) -> matchCount == 6);

    private final int count;
    private final String winningAmount;
    private final BiPredicate<Integer, Boolean> checkWin;

    LottoRank(int count, String winningAmount, BiPredicate<Integer, Boolean> checkWin) {
        this.count = count;
        this.winningAmount = winningAmount;
        this.checkWin = checkWin;
    }

    public static LottoRank of(int matchCount, boolean isBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.checkWin.test(matchCount, isBonus))
                .findFirst()
                .orElse(ZERO);
    }

    public int getCount() {
        return count;
    }

    public String getWinningAmount() {
        return winningAmount;
    }
}
