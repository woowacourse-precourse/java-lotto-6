package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {

    NONE(0, 0, false),
    FIFTH_PRIZE(5000, 3, false),
    FORTH_PRIZE(50000, 4, false),
    THIRD_PRIZE(1500000, 5, false),
    SECOND_PRIZE(30000000, 5, true),
    FIRST_PRIZE(2000000000, 6, false);

    private final Integer amount;
    private final Integer matchingCount;
    private final Boolean bonusBallMatchRequired;

    LottoPrize(Integer amount, Integer matchingCount, Boolean bonusBallMatchRequired) {
        this.amount = amount;
        this.matchingCount = matchingCount;
        this.bonusBallMatchRequired = bonusBallMatchRequired;
    }

    public static LottoPrize findByMatchingCountAndBonusBall(Lotto boughtLotto, WinningLotto winningLotto) {
        return Arrays.stream(LottoPrize.values())
                .filter(e -> e.matchingCount == winningLotto.getMatchedCountCompareTo(boughtLotto))
                .filter(e -> e.bonusBallMatchRequired == e.matchBonusBall(
                        winningLotto.getMatchedCountCompareTo(boughtLotto),
                        winningLotto.isBonusNumMatchedTo(boughtLotto)))
                .findAny()
                .orElse(NONE);
    }

    private boolean matchBonusBall(int matchingCount, boolean bonusBallMatch) {
        if (matchingCount == 5) {
            return bonusBallMatch;
        }

        return false;
    }

    public Integer amount() {
        return amount;
    }

    public Integer matchingCount() {
        return matchingCount;
    }

    public Boolean bonusBallMatchRequired() {
        return bonusBallMatchRequired;
    }

}
