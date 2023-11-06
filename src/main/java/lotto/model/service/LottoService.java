package lotto.model.service;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoResult;
import lotto.model.domain.WinningNumber;

public class LottoService {

    private final LottoGenerator lottoGenerator;
    private final LottoChecker lottoChecker;

    public LottoService(LottoGenerator lottoGenerator, LottoChecker lottoChecker) {
        this.lottoGenerator = lottoGenerator;
        this.lottoChecker = lottoChecker;
    }

    public List<Lotto> purchaseLotto(int money) {
        return lottoGenerator.purchaseLotto(money);
    }

    public LottoResult findWinningLottos(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottoChecker.findWinningLottos(lottos, winningNumber);
    }

}
