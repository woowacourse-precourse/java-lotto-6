package lotto.winningLotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.userLotto.domain.Lotto;
import lotto.userLotto.domain.Lottos;
import lotto.rank.domain.Rank;

public class WinningLotto {
    private final LottoNumber lottoNumber;
    private final LottoBonusNumber lottoBonusNumber;

    public WinningLotto(LottoNumber lottoNumber, LottoBonusNumber lottoBonusNumber) {
        if(lottoNumber.contains(lottoBonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public LottoBonusNumber getLottoBonusNumber() {
        return lottoBonusNumber;
    }
}
