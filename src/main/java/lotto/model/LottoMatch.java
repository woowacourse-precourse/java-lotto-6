package lotto.model;

import java.util.Arrays;

public enum LottoMatch {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_AND_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000),
    NOTHING(0, false, 0);

    private final int matching;
    private final boolean bonusMatching;
    private final int amount;

    LottoMatch(int matching, boolean bonusMatching, int amount) {
        this.matching = matching;
        this.bonusMatching = bonusMatching;
        this.amount = amount;
    }

    public int getMatching() {
        return matching;
    }

    public int getAmount() {
        return amount;
    }

    public static LottoMatch collect(int matching, boolean bonusMatching) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matching == matching && lottoMatch.bonusMatching == bonusMatching)
                .findFirst()
                .orElse(LottoMatch.NOTHING);
    }
}
