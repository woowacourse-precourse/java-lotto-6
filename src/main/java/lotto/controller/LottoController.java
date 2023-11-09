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
        List<Lotto> winningLottos = generateWinningLottos(getPurchasedLottoCount(purchaseAmount));
        Lotto lotto = prepareLotto();
        LottoNumber bonusNumber = prepareBonusNumber();

        PlayerLotto playerLotto = preparePlayer(purchaseAmount, lotto, bonusNumber);

        return LottoManager.create(winningLottos, playerLotto);
    }

    private PurchaseAmount preparePurchaseAmount() {
        return PurchaseAmount.create(View.readPurchaseAmount());
    }

    private int getPurchasedLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculatePurchasedLottoCount(purchaseAmount);
    }

    private List<Lotto> generateWinningLottos(int purchasedLottoCount) {
        List<Lotto> winningLottos = LottoGenerator.generateWinningLottos(purchasedLottoCount);
        View.printWinningLottosMessage(winningLottos, purchasedLottoCount);
        return winningLottos;
    }

    private Lotto prepareLotto() {
        return Lotto.create(View.readLottoNumbers());
    }

    private LottoNumber prepareBonusNumber() {
        return LottoNumber.create(View.readBonusNumber());
    }

    private PlayerLotto preparePlayer(PurchaseAmount purchaseAmount, Lotto lotto, LottoNumber bonusNumber) {
        return PlayerLotto.create(lotto, bonusNumber, purchaseAmount);
    }

    private void printResult(LottoManager lottoManager) {
        List<PrizeResponse> winningResult = lottoManager.getWinningResult();
        double profitRate = lottoManager.calculateProfitRate(winningResult);

        View.printWinningStatusMessage(winningResult, profitRate);
        View.closeRead();
    }
}
