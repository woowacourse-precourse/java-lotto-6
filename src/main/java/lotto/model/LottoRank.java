package lotto.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoRank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }


    public static LottoRank valueOf(long matchCount, boolean bonusBall) {

        if (matchCount == LottoRank.SECOND.matchCount && bonusBall) {
            return LottoRank.SECOND;
        }

        if (matchCount < LottoRank.FIFTH.matchCount) {
            return LottoRank.NONE;
        }

        return Arrays.stream(LottoRank.values()).filter(rank -> rank.matchCount == matchCount).findAny()
                .orElseThrow(NoSuchElementException::new);
    }


}
