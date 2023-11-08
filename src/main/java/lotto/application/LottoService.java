package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public User purchaseLotto(int purchasePrice) {
        return new User(purchasePrice, lottoNumberGenerator);
    }

    public WinningLotto makeWinningLotto(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
