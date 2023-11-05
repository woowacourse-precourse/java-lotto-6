package lotto.model;

import java.util.Arrays;

public enum LottoMatch {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_AND_BONUS_MATCH(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000),
    NOTHING_MATCH(0, false, 0);

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
        if (matching >= 5) {
            return filterLottoMatch(matching, bonusMatching);
        }
        return filterLottoMatch(matching, false);
    }

    private static LottoMatch filterLottoMatch(int matching, boolean bonusMatching) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matching == matching && lottoMatch.bonusMatching == bonusMatching)
                .findFirst()
                .orElse(LottoMatch.NOTHING_MATCH);
    }
}
