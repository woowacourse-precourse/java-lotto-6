package lotto.constant;

import java.util.Arrays;

public enum LottoRank {

    THREE(3, 5_000, "3개 일치 (%,d원)"),
    FOUR(4, 50_000, "4개 일치 (%,d원)"),
    FIVE(5, 1_500_000, "5개 일치 (%,d원)"),
    FIVE_BONUS(10, 30_000_000, "5개 일치, 보너스 볼 일치 (%,d원)"),
    SIX(6, 2_000_000_000, "6개 일치 (%,d원)"),
    NOTHING(0, 0, null);

    private final int winningCount;
    private final int prize;
    private final String string;

    LottoRank(int winningCount, int prize, String string) {
        this.winningCount = winningCount;
        this.prize = prize;
        this.string = string;
    }

    public static LottoRank findRank(int winningCount, int bonus) {
        if (winningCount == 5 && bonus == 1) {
            return FIVE_BONUS;
        }
        return Arrays.stream(values())
                .filter(value -> value.winningCount == winningCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return String.format(string, prize);
    }

}
