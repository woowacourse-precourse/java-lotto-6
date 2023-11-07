package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPlace {
    FIRST(new LottoStatus(6), new Money(5000), false),
    SECOND(new LottoStatus(5, true), new Money(5000), true),
    THIRD(new LottoStatus(5), new Money(5000), false),
    FOURTH(new LottoStatus(4), new Money(5000), false),
    FIFTH(new LottoStatus(3), new Money(5000), false);

    private final LottoStatus lottoStatus;
    private final Money prizeAmount;
    private final boolean isBonusRequired;

    LottoPlace(LottoStatus lottoStatus, Money prizeAmount, boolean isBonusRequired) {
        this.lottoStatus = lottoStatus;
        this.prizeAmount = prizeAmount;
        this.isBonusRequired = isBonusRequired;
    }

    public static Optional<LottoPlace> judgeLottoPlace(LottoStatus lottoStatus) {
        return Arrays.stream(LottoPlace.values())
                .filter((lottoPlace) -> lottoPlace.isRightPlace(lottoStatus))
                .findAny();
    }

    private boolean isRightPlace(LottoStatus lottoStatus) {
        return this.lottoStatus.isSameStatus(lottoStatus, this.isBonusRequired);
    }
}
