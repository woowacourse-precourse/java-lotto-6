package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.PlayerLotto;
import lotto.util.LottoGenerator;
import lotto.domain.lottoManage.LottoManager;
import lotto.domain.lottoManage.PurchaseAmount;
import lotto.dto.response.PrizeResponse;
import lotto.view.View;

import java.util.List;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<Lotto> winningLottos = generateWinningLottos(purchaseAmount);
        PlayerLotto playerLotto = generatePlayerLotto();
        LottoManager lottoManager = LottoManager.create(winningLottos, purchaseAmount, playerLotto);

        printResult(lottoManager, playerLotto);
    }

    private PurchaseAmount readPurchaseAmount() {
        return PurchaseAmount.create(View.readPurchaseAmount());
    }

    private List<Lotto> generateWinningLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> winningLottos = LottoGenerator.generateWinningLottos(purchaseAmount);
        View.printWinningLottosMessage(winningLottos, purchaseAmount.calculatePurchasedLottoCount());
        return winningLottos;
    }

    private PlayerLotto generatePlayerLotto() {
        Lotto lotto = readLotto();
        LottoNumber bonusNumber = readBonusNumber();
        return PlayerLotto.create(lotto, bonusNumber);
    }

    private Lotto readLotto() {
        return Lotto.create(View.readLottoNumbers());
    }

    private LottoNumber readBonusNumber() {
        return LottoNumber.create(View.readBonusNumber());
    }

    private void printResult(LottoManager lottoManager, PlayerLotto playerLotto) {
        List<PrizeResponse> winningResult = lottoManager.getWinningResult(playerLotto);
        double profitRate = lottoManager.calculateProfitRate(winningResult);

        View.printWinningStatusMessage(winningResult, profitRate);
        View.closeRead();
    }
}
