package domain;

import exception.DuplicateTierConditionException;
import exception.ImpossibleStateException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum LottoWinningTier {
    FIRST_TIER(6, false, 2_000_000_000),
    SECOND_TIER(5, true, 30_000_000),
    THIRD_TIER(5, false, 1_500_000),
    FOURTH_TIER(4, false, 50_000),
    FIFTH_TIER(3, false, 5_000);

    private final int matchCount;
    private final boolean requireMatchBonus;
    private final int prizeAmount;

    LottoWinningTier(int matchCount, boolean matchBonus, int prizeAmount) {
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

    public static Optional<LottoWinningTier> calculateTier(int matchCount, boolean matchBonus) {
        validateMatchCount(matchCount);

        return calculateBonusTier(matchCount, matchBonus)
                .or(() -> Optional.ofNullable(TIER_CALCULATOR_WITH_NO_BONUS.get(matchCount)));
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount < 0 || FIRST_TIER.getMatchCount() < matchCount) {
            throw new ImpossibleStateException();
        }
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

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
