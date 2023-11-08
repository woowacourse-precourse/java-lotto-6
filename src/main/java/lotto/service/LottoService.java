package lotto.service;

import java.util.List;
import lotto.domain.LottoManager;
import lotto.domain.LottoSeller;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lottos;
import lotto.domain.prize.WinningDetails;

public class LottoService {
    private final LottoManager lottoManager;
    private Lottos lottos;
    private PurchaseAmount purchaseAmount;

    private LottoService(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public static LottoService getInstance() {
        WinningDetails winningDetails = WinningDetails.createWinningDetails();
        LottoManager lottoManager = LottoManager.from(winningDetails);

        return new LottoService(lottoManager);
    }

    public List<String> buyLotto(int money) {
        LottoSeller lottoSeller = new LottoSeller();
        purchaseAmount = new PurchaseAmount(money);
        lottos = lottoSeller.getLottos(purchaseAmount);

        return lottos.getIssuedLottoNumbers();
    }

    public void drawWinningLotto(List<Integer> numbers, int bonusNumber) {
        lottoManager.createWinningLotto(numbers, bonusNumber);
    }

    public WinningDetails getWinningResult() {
        return lottoManager.statisticsPrize(lottos);
    }

    public double getProfitRate() {
        return lottoManager.calculateProfitRate(purchaseAmount);
    }
}
