package lotto.domain;

import java.util.List;

public record WinningLotto(List<Integer> numbers, int bonusNumber) {
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    public LottoPrizes compare(Lotto lotto) {
        long matchCount = getMatchCount(lotto);
        if (matchCount == THREE) {
            return LottoPrizes.THREE_NUMBERS_MATCHED;
        }
        if (matchCount == FOUR) {
            return LottoPrizes.FOUR_NUMBERS_MATCHED;
        }
        if (matchCount == FIVE) {
            return LottoPrizes.FIVE_NUMBER_MATCHED;
        }
        if (matchCount == SIX && lotto.isContain(bonusNumber)) {
            return LottoPrizes.FIVE_NUMBER_AND_BONUS_MATCHED;
        }
        if (matchCount == SIX) {
            return LottoPrizes.SIX_NUMBER_MATCHED;
        }
        return null;
    }

    public long getMatchCount(Lotto lotto) {
        long matchCount = numbers.stream()
                .filter(lotto::isContain)
                .count();

        if (lotto.isContain(bonusNumber)) {
            matchCount++;
        }

        return matchCount;
    }
}
