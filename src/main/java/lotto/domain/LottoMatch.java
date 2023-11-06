package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoMatch {
    NON_PLACE(0, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private final int matchCount;
    private final int amount;

    LottoMatch(final int matchCount, final int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public static LottoMatch getLottoMatch(final int matchCount, final boolean isBonus) {
        if (matchCount == 5 && isBonus) return SECOND_PLACE;

        List<LottoMatch> lottoMatches = Arrays.stream(LottoMatch.values()).toList();
        for (LottoMatch lottoMatch : lottoMatches) {
            if (lottoMatch.matchCount == matchCount) return lottoMatch;
        }
        return NON_PLACE;
    }
}
