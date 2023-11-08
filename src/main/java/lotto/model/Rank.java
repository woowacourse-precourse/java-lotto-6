package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST_PLACE(2_000_000_000, 6, (matchLottoNumberCount, bonusNumberContain) -> matchLottoNumberCount == 6),
    SECOND_PLACE(30_000_000, 5,
            (matchLottoNumberCount, bonusNumberContain) -> matchLottoNumberCount == 5 && bonusNumberContain),
    THIRD_PLACE(1_500_000, 5,
            (matchLottoNumberCount, bonusNumberContain) -> matchLottoNumberCount == 5 && !bonusNumberContain),
    FOURTH_PLACE(50_000, 4, (matchLottoNumberCount, bonusNumberContain) -> matchLottoNumberCount == 4),
    FIFTH_PLACE(5_000, 3, (matchLottoNumberCount, bonusNumberContain) -> matchLottoNumberCount == 3),
    LOSE(0, 6, (matchLottoNumberCount, bonusNumberContain) -> matchLottoNumberCount < 3);

    private final int reward;
    private final int matchLottoNumberCount;
    private final BiPredicate<Integer, Boolean> match;

    Rank(int reward, int matchLottoNumberCount, BiPredicate<Integer, Boolean> match) {
        this.reward = reward;
        this.matchLottoNumberCount = matchLottoNumberCount;
        this.match = match;
    }

    public static Rank getRank(final int matchLottoNumberCount, final boolean bonusNumberContain) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match.test(matchLottoNumberCount, bonusNumberContain))
                .findAny()
                .orElse(LOSE);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchLottoNumberCount() {
        return matchLottoNumberCount;
    }
}
