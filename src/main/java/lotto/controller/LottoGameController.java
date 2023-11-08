package lotto.controller;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.view.InputView;
import lotto.domain.Lotto;
import lotto.service.LottoDrawService;
import lotto.service.PurchaseService;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    PurchaseService purchaseService = new PurchaseService();
    LottoDrawService lottoDrawService = new LottoDrawService();

    public void start() {
        int payment = getPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLotto(payment);
        displayPurchasedLottos(purchasedLottos);

        LottoRanks lottoRanks = getRanks(getWinningLotto(), purchasedLottos);
        int winningAmount = getWinningAmount();

        displayWinningResult(lottoRanks);
        displayReturnsResult(evaluateLottoReturns(payment, winningAmount));
    }

    private int getPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    private List<Lotto> purchaseLotto(int payment) {
        int countOfPurchasable = purchaseService.getCountOfPurchasable(payment);
        OutputView.printPurchaseCountResult(countOfPurchasable);
        return purchaseService.purchaseLottoForCount(countOfPurchasable);
    }


    private void displayReturnsResult(String lottoReturns) {
        OutputView.printReturnsResult(lottoReturns);
    }

    private void displayWinningResult(LottoRanks lottoRanks) {
        for (LottoRank rank : LottoRank.values()) {
            OutputView.printWinningLottoResult(rank, lottoRanks.getRankCount(rank));
        }
    }

    private void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            OutputView.printGeneratedLottoResult(lotto.getNumbers());
        }
    }

    private WinningLotto getWinningLotto() {
        return new WinningLotto(
                new Lotto(InputView.inputWinningNumbers()),
                InputView.inputBonusNumber()
        );
    }

    private LottoRanks getRanks(WinningLotto winningLotto, List<Lotto> purchasedLottos) {
        return lottoDrawService.evaluateRanks(winningLotto, purchasedLottos);
    }

    private int getWinningAmount() {
        return lottoDrawService.getWinningAmount();
    }

    private String evaluateLottoReturns(int payment, int winningAmount) {
        float returns = ((float) winningAmount / payment) * 100;
        return String.format("%.2f%%", returns);
    }

}
