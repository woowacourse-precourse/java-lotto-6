package lotto.model.prize;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum PrizeType {
    NO_MATCH(0, 0, (prizeEvaluator, isBonusMatch) -> {}),
    ONE_MATCH(1, 0, (prizeEvaluator, isBonusMatch) -> {}),
    TWO_MATCH(2, 0, (prizeEvaluator, isBonusMatch) -> {}),
    THREE_MATCH(3, 5_000, (prizeEvaluator, isBonusMatch) -> prizeEvaluator.increaseThreeMatchPrize()),
    FOUR_MATCH(4, 50_000, (prizeEvaluator, isBonusMatch) -> prizeEvaluator.increaseFourMatchPrize()),
    FIVE_MATCH(5, 1_500_000, (prizeEvaluator, isBonusMatch) -> prizeEvaluator.increaseFiveMatchPrize()),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000, (prizeEvaluator, isBonusMatch) -> prizeEvaluator.increaseFiveMatchWithBonusPrize()),
    SIX_MATCH(6, 2_000_000_000, (prizeEvaluator, isBonusMatch) -> prizeEvaluator.increaseSixMatchPrize());

    private final int matchCount;
    private final int prizeMoney;
    private final BiConsumer<PrizeEvaluator, Boolean> prizeIncreaseAction;

    PrizeType(int matchCount, int prizeMoney, BiConsumer<PrizeEvaluator, Boolean> prizeIncreaseAction) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.prizeIncreaseAction = prizeIncreaseAction;
    }

    public void increasePrize(PrizeEvaluator prizeEvaluator, boolean isBonusMatch) {
        if (prizeMoney > 0) {
            prizeIncreaseAction.accept(prizeEvaluator, isBonusMatch);
        }
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static PrizeType valueOf(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return FIVE_MATCH_WITH_BONUS;
        }

        return Arrays.stream(values())
                .filter(type -> type.matchCount == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
