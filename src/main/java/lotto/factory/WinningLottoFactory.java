package lotto.factory;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class WinningLottoFactory {

    private final LottoFactory lottoFactory;

    public WinningLottoFactory(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public WinningLotto createWinningLotto(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        return new WinningLotto(winningLotto, bonusNumber);
    }
}