package lotto.domain.lotto;

import java.util.List;
import java.util.Optional;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    public static final List<LottoRank> ranks = List.of(values());
    private final int matchCount;
    private final boolean hasBonusNumber;
    private final long prize;

    LottoRank(int matchCount, boolean hasBonusNumber, long prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean hasBonusNumber) {
        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }

        Optional<LottoRank> lottoRank = ranks.stream()
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.hasBonusNumber == hasBonusNumber)
                .findFirst();

        return lottoRank.orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }

}
