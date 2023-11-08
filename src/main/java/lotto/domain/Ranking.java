package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Ranking {

    NONE(0, (correctCount, hasBonus) -> correctCount < 3, 0),
    FIFTH(3, (correctCount, hasBonus) -> correctCount == 3, 5_000),
    FOURTH(4, (correctCount, hasBonus) -> correctCount == 4, 50_000),
    THIRD(5, (correctCount, hasBonus) -> correctCount == 5 && !hasBonus, 1_500_000),
    SECOND(5, (correctCount, hasBonus) -> correctCount == 5 && hasBonus, 30_000_000),
    FIRST(6, (correctCount, hasBonus) -> correctCount == 6, 2_000_000_000);


    private final int correctCount;
    private final BiPredicate<Integer, Boolean> condition;
    private final int prize;

    Ranking(int correctCount, BiPredicate<Integer, Boolean> condition, int prize) {
        this.correctCount = correctCount;
        this.condition = condition;
        this.prize = prize;
    }

    public static Ranking from(int correctCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.condition.test(correctCount, hasBonus))
                .findAny()
                .orElse(NONE);
    }

    public static List<Ranking> rankingWithoutDefault(){
        return Arrays.stream(values())
                .filter(ranking -> ranking!=NONE)
                .collect(Collectors.toList());
    }

    public long calculatePrizeSum(long rankingCount) {
        return this.prize * rankingCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }
}
