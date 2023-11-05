package lotto;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Rank {
    THREE(3, 3_000, " "),
    FOUR(4, 50_000, " "),
    FIVE(5, 1_500_000, " "),
    BONUS(5, 30_000_000, ", 보너스 볼 일치 "),
    SIX(6, 2_000_000_000, " "),
    NOPE(0, 0, " ");

    private int rank;
    private int reward;
    private String message;

    Rank(int rank, int reward, String message) {
        this.rank = rank;
        this.reward = reward;
        this.message = message;
    }

    public static Rank get(int same) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.rank == same)
                .findAny()
                .orElse(NOPE);
    }

    public static int getReward(Rank rank) {
        return Arrays.stream(Rank.values())
                .filter(r -> r == rank)
                .findAny().get().reward;
    }

    public static String getMsg(Rank rank) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String reward = numberFormat.format(rank.reward);
        return rank.rank + "개 일치" + rank.message+"(" + reward + "원)";
    }
}
