package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    NONE(0, 0, 0, "0원"),
    FIFTH(5000, 3, 0, "5,000원"),
    FOURTH(50000, 4, 0, "50,000원"),
    THIRD(1500000, 5, 0, "1,500,000원"),
    SECOND(30000000, 5, 1, "30,000,000원"),
    FIRST(2000000000, 6, 0, "2,000,000,000원");

    final private int prize;
    final private int winningMatchCount;
    final private int bonusMatchCount;
    final private String prizeOutput;

    Rank(int prize, int winningMatchCount, int bonusMatchCount, String prizeOutput) {
        this.prize = prize;
        this.winningMatchCount = winningMatchCount;
        this.bonusMatchCount = bonusMatchCount;
        this.prizeOutput = prizeOutput;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getWinningMatchCount() {
        return this.winningMatchCount;
    }

    public String getPrizeOutput() {
        return this.prizeOutput;
    }

    private static final Map<List<Integer>, Rank> BY_WINNING_BONUS_COUNT = Stream.of(values()).collect(
            Collectors.toMap(rank -> List.of(rank.getWinningMatchCount(), rank.bonusMatchCount), Function.identity()));

    public static Rank valueOfWinningBonusCount(List<Integer> numbers) {
        return BY_WINNING_BONUS_COUNT.get(numbers);
    }

}
