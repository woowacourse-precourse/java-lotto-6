package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPlace {
    FIFTH(new LottoStatus(3), new Money("5000"), false),
    FOURTH(new LottoStatus(4), new Money("50000"), false),
    THIRD(new LottoStatus(5), new Money("1500000"), true),
    SECOND(new LottoStatus(5, true), new Money("30000000"), true),
    FIRST(new LottoStatus(6), new Money("2000000000"), false);

    private final LottoStatus lottoStatus;
    private final Money prizeAmount;
    private final boolean requireBonusJudge;

    LottoPlace(LottoStatus lottoStatus, Money prizeAmount, boolean requireBonusJudge) {
        this.lottoStatus = lottoStatus;
        this.prizeAmount = prizeAmount;
        this.requireBonusJudge = requireBonusJudge;
    }

    public static Optional<LottoPlace> judgeLottoPlace(LottoStatus lottoStatus) {
        return Arrays.stream(LottoPlace.values())
                .filter((lottoPlace) -> lottoPlace.isRightPlace(lottoStatus))
                .findAny();
    }

    public LottoStatus getLottoStatus() {
        return lottoStatus;
    }

    public Money getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isRequireBonusJudge() {
        return requireBonusJudge;
    }

    private boolean isRightPlace(LottoStatus lottoStatus) {
        return this.lottoStatus.isSameStatus(lottoStatus, this.requireBonusJudge);
    }
}
