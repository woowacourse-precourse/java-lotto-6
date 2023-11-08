package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    NONE(0, LottoPrizeCondition.of(0, false)),
    FIFTH_PRIZE(5000, LottoPrizeCondition.of(3, false)),
    FORTH_PRIZE(50000, LottoPrizeCondition.of(4, false)),
    THIRD_PRIZE(1500000, LottoPrizeCondition.of(5, false)),
    SECOND_PRIZE(30000000, LottoPrizeCondition.of(5, true)),
    FIRST_PRIZE(2000000000, LottoPrizeCondition.of(6, false));

    private final Integer amount;
    private final LottoPrizeCondition lottoPrizeCondition;

    LottoPrize(Integer amount, LottoPrizeCondition lottoPrizeCondition) {
        this.amount = amount;
        this.lottoPrizeCondition = lottoPrizeCondition;
    }

    public static LottoPrize findByMatchingCountAndBonusBall(Lotto boughtLotto, WinningLotto winningLotto) {
        LottoPrizeCondition condition = createLottoPrizeCondition(boughtLotto, winningLotto);
        return findLottoPrizeByCondition(condition);
    }

    public Integer amount() {
        return amount;
    }

    public LottoPrizeCondition getLottoPrizeCondition() {
        return lottoPrizeCondition;
    }

    private static LottoPrizeCondition createLottoPrizeCondition(Lotto boughtLotto, WinningLotto winningLotto) {
        return LottoPrizeCondition.of(winningLotto.getMatchedCountCompareTo(boughtLotto), winningLotto.isBonusNumMatchedTo(boughtLotto));
    }

    private static LottoPrize findLottoPrizeByCondition(LottoPrizeCondition condition) {
        return Arrays.stream(LottoPrize.values())
                .filter(e -> e.lottoPrizeCondition.equals(condition))
                .findAny()
                .orElse(LottoPrize.NONE);
    }

}
