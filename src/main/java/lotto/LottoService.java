package lotto;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;

public class LottoService {

    private Lottos lottos;

    public void createLottos(int amountOfPurchasedLotto) {
        List<Lotto> lottoList = LottoMaker.makeLotto(amountOfPurchasedLotto);
        this.lottos = new Lottos(lottoList);
    }

    public List<LottoDTO> getLottoDTOs() {
        return lottos.getLottoDTOs();
    }

    public WinningResult getWinningResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return lottos.getWinningResult(winningNumber, bonusNumber);
    }
}
