package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.PlayerLotto;
import lotto.domain.lottoManage.LottoGenerator;
import lotto.domain.lottoManage.LottoManager;
import lotto.domain.lottoManage.PurchaseAmount;
import lotto.dto.response.PrizeResponse;
import lotto.view.View;

import java.util.List;

public class LottoController {

    public void run() {
        LottoManager lottoManager = prepareGame();
        printResult(lottoManager);
    }

    private LottoManager prepareGame() {
        PurchaseAmount purchaseAmount = preparePurchaseAmount();
        List<Lotto> winningLottos = generateWinningLottos(purchaseAmount);
        Lotto lotto = prepareLotto();
        LottoNumber bonusNumber = prepareBonusNumber();

        PlayerLotto playerLotto = preparePlayer(lotto, bonusNumber);

        return LottoManager.create(winningLottos, purchaseAmount, playerLotto);
    }

    private PurchaseAmount preparePurchaseAmount() {
        return PurchaseAmount.create(View.readPurchaseAmount());
    }

    private List<Lotto> generateWinningLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> winningLottos = LottoGenerator.generateWinningLottos(purchaseAmount);
        View.printWinningLottosMessage(winningLottos, purchaseAmount.calculatePurchasedLottoCount());
        return winningLottos;
    }

    private Lotto prepareLotto() {
        return Lotto.create(View.readLottoNumbers());
    }

    private LottoNumber prepareBonusNumber() {
        return LottoNumber.create(View.readBonusNumber());
    }

    private PlayerLotto preparePlayer(Lotto lotto, LottoNumber bonusNumber) {
        return PlayerLotto.create(lotto, bonusNumber);
    }

    private void printResult(LottoManager lottoManager) {
        List<PrizeResponse> winningResult = lottoManager.getWinningResult();
        double profitRate = lottoManager.calculateProfitRate(winningResult);

        View.printWinningStatusMessage(winningResult, profitRate);
        View.closeRead();
    }
}
