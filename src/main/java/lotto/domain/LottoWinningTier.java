package lotto.domain;

import lotto.dto.WinningMatchResult;
import lotto.exception.DuplicateTierConditionException;
import lotto.exception.ImpossibleStateException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum LottoWinningTier {
    FIFTH_TIER(3, false, new Amount(5_000)),
    FOURTH_TIER(4, false, new Amount(50_000)),
    THIRD_TIER(5, false, new Amount(1_500_000)),
    SECOND_TIER(5, true, new Amount(30_000_000)),
    FIRST_TIER(6, false, new Amount(2_000_000_000));

    private final int matchCount;
    private final boolean requireMatchBonus;
    private final Amount prizeAmount;

    LottoWinningTier(int matchCount, boolean matchBonus, Amount prizeAmount) {
        this.matchCount = matchCount;
        this.requireMatchBonus = matchBonus;
        this.prizeAmount = prizeAmount;
    }

    private static final Map<Integer, LottoWinningTier> TIER_CALCULATOR_WITH_BONUS =
            generateTierCalculator(true);
    private static final Map<Integer, LottoWinningTier> TIER_CALCULATOR_WITH_NO_BONUS =
            generateTierCalculator(false);

    private static Map<Integer, LottoWinningTier> generateTierCalculator(boolean matchBonus) {
        Map<Integer, LottoWinningTier> calculator = new HashMap<>();

        Arrays.stream(LottoWinningTier.values())
                .filter(tier -> tier.isRequireMatchBonus() == matchBonus)
                .forEach(tier -> LottoWinningTier.putIfAbsentOrThrow(calculator, tier));

        return Collections.unmodifiableMap(calculator);
    }

    private static void putIfAbsentOrThrow(Map<Integer, LottoWinningTier> tierCalculator, LottoWinningTier tier) {
        int tierMatchCount = tier.getMatchCount();

        if (tierCalculator.containsKey(tierMatchCount)) {
            throw new DuplicateTierConditionException();
        }

        tierCalculator.put(tierMatchCount, tier);
    }

    public static Optional<LottoWinningTier> calculateTier(WinningMatchResult winningMatchResult) {
        int matchCount = winningMatchResult.getMatchCount();
        boolean matchBonus = winningMatchResult.isMatchBonus();
        validateMatchCondition(matchCount, matchBonus);

        return calculateBonusTier(matchCount, matchBonus)
                .or(() -> Optional.ofNullable(TIER_CALCULATOR_WITH_NO_BONUS.get(matchCount)));
    }

    private static void validateMatchCondition(int matchCount, boolean matchBonus) {
        if (isMatchCountLessThanZero(matchCount) || isMatchConditionOverFirstTier(matchCount, matchBonus)) {
            throw new ImpossibleStateException();
        }
    }

    private static boolean isMatchCountLessThanZero(int matchCount) {
        return matchCount < 0;
    }

    private static boolean isMatchConditionOverFirstTier(int matchCount, boolean matchBonus) {
        int matchBonusCount = convertBooleanToInt(matchBonus);

        return FIRST_TIER.getMatchCount() < matchCount + matchBonusCount;
    }

    private static int convertBooleanToInt(boolean matchBonus) {
        if (matchBonus) {
            return 1;
        }

        return 0;
    }

    private static Optional<LottoWinningTier> calculateBonusTier(int matchCount, boolean matchBonus) {
        if (matchBonus) {
            return Optional.ofNullable(TIER_CALCULATOR_WITH_BONUS.get(matchCount));
        }

        return Optional.empty();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequireMatchBonus() {
        return requireMatchBonus;
    }

    public Amount getPrizeAmount() {
        return prizeAmount;
    }
}
