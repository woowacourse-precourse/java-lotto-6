package lotto.service;

import lotto.Lotto;
import lotto.LottoPublisher;
import lotto.LottoResult;

import java.util.List;

public class LottoService {


    public LottoService() {
    }

    public List<Lotto> purchaseLotto(Long purchaseAmount) {
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Lotto> lottos = lottoPublisher.publishLotto(purchaseAmount);
        return lottos;
    }

    public void compareLotto(List<String> winningNumbers, Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.showLottoResult(winningNumbers, bonusNumber, lottos);
    }
}
