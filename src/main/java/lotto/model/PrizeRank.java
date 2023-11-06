package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

public enum PrizeRank {
    THREE(3, 5_000, " "),
    FOUR(4, 50_000, " "),
    FIVE(5, 1_500_000, " "),
    BONUS(5, 30_000_000, ", 보너스 볼 일치 "),
    SIX(6, 2_000_000_000, " "),
    NOPE(0, 0, " ");

    private final int rank;
    private final int reward;
    private final String message;

    PrizeRank(int rank, int reward, String message) {
        this.rank = rank;
        this.reward = reward;
        this.message = message;
    }

    public static PrizeRank get(int same) {
        return Arrays.stream(PrizeRank.values())
                .filter(prizeRank -> prizeRank.rank == same)
                .findAny()
                .orElse(NOPE);
    }

    public static int getReward(PrizeRank prizeRank) {
        return Arrays.stream(PrizeRank.values())
                .filter(r -> r == prizeRank)
                .findAny().get().reward;
    }

    public static String getMsg(PrizeRank prizeRank) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String reward = numberFormat.format(prizeRank.reward);
        return prizeRank.rank + "개 일치" + prizeRank.message + "(" + reward + "원)";
    }
}
