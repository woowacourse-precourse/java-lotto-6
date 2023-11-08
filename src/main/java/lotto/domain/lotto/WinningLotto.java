package lotto.domain.lotto;

import lotto.domain.message.ErrorMessage;
import lotto.domain.result.WinningRank;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber lottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        validate(lotto, lottoNumber);
        this.lotto = lotto;
        this.lottoNumber = lottoNumber;
    }

    private void validate(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.hasSameNumber(lottoNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATION_EXCEPTION_MESSAGE.getMessage());
        }
    }
    public WinningRank findWinningRank(Lotto lotto) {
        int matchCount = lotto.calculateMatchCount(this.lotto);
        boolean hasBonusNumber = lotto.hasSameNumber(lottoNumber);
        return WinningRank.findWinningRank(matchCount, hasBonusNumber);
    }
}
