package lotto.controller;

import lotto.domain.LottoManager;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.player.Player;
import lotto.domain.PurchaseAmount;
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

        Player player = preparePlayer(purchaseAmount, lotto, bonusNumber);

        return LottoManager.create(winningLottos, player);
    }

    private PurchaseAmount preparePurchaseAmount() {
        return PurchaseAmount.create(View.readPurchaseAmount());
    }

    private int getPurchasedLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculatePurchasedLottoCount(purchaseAmount);
    }

    private List<Lotto> generateWinningLottos(int purchasedLottoCount) {
        List<Lotto> winningLottos = LottoManager.generateWinningLottos(purchasedLottoCount);
        View.printWinningLottosMessage(winningLottos, purchasedLottoCount);
        return winningLottos;
    }

    private Lotto prepareLotto() {
        return Lotto.create(View.readLottoNumbers());
    }

    private LottoNumber prepareBonusNumber() {
        return LottoNumber.create(View.readBonusNumber());
    }

    private Player preparePlayer(PurchaseAmount purchaseAmount, Lotto lotto, LottoNumber bonusNumber) {
        return Player.create(lotto, bonusNumber, purchaseAmount);
    }

    private void printResult(LottoManager lottoManager) {
        List<PrizeResponse> winningResult = lottoManager.getWinningResult();
        double profitRate = lottoManager.calculateProfitRate(winningResult);

        View.printWinningStatusMessage(winningResult, profitRate);
        View.closeRead();
    }
}
