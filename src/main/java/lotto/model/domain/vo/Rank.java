package lotto.model.domain.vo;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {

    FIRST("1등", 20_000_000_000L, (win, bonus) -> win == 6),
    SECOND("2등", 30_000_000L, (win, bonus) -> win == 5 && bonus == 1),
    THIRD("3등", 1_500_000L, (win, bonus) -> win == 5),
    FOURTH("4등", 50_000L, (win, bonus) -> win == 4),
    FIFTH("5등", 5_000L, (win, bonus) -> win == 3),
    NONE("꽝", 0L, (win, bonus) -> win < 3);

    private String rank;
    private long money;
    private int headCount;
    private BiFunction<Integer, Integer, Boolean> expression;

    Rank(String rank, long money, BiFunction<Integer, Integer, Boolean> expression) {
        this.rank = rank;
        this.money = money;
        this.headCount = 0;
        this.expression = expression;
    }

    public static Rank winner(int winCount, int bonusCount) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.expression.apply(winCount, bonusCount))
                .findFirst()
                .orElse(Rank.NONE);
    }

    public long getMoney() {
        return money;
    }
}
