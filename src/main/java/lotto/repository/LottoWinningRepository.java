package lotto.repository;

import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;

public class LottoWinningRepository {

    private Lotto winningLotto;
    private LottoBonusNumber lottoBonusNumber;

    public Lotto saveLottoWinningNumbers(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        return winningLotto;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoBonusNumber saveLottoBonusNumber(LottoBonusNumber lottoBonusNumber) {
        this.lottoBonusNumber = lottoBonusNumber;
        return lottoBonusNumber;
    }

    public LottoBonusNumber getLottoBonusNumber() {
        return lottoBonusNumber;
    }

}
