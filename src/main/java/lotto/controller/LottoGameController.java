package lotto.controller;

import lotto.constants.LottoRankConstants;
import lotto.domain.LottoRanks;
import lotto.service.ReturnService;
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
    ReturnService returnService = new ReturnService();

    public void start() {
        int payment = getPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLotto(payment);
        displayPurchasedLottos(purchasedLottos);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);

        LottoRanks lottoRanks = getRanks(
                new WinningLotto(winningLotto, bonusNumber),
                purchasedLottos
        );
        int winningAmount = getWinningAmount();
        displayWinningResult(lottoRanks);

        displayReturnsResult(getReturn(payment, winningAmount));
    }

    private int getBonusNumber(Lotto winningLotto) {
        return InputView.inputBonusNumber(winningLotto);
    }

    private int getPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    private Lotto getWinningLotto() {
        return new Lotto(InputView.inputWinningNumbers());
    }

    private List<Lotto> purchaseLotto(int payment) {
        int countOfPurchasable = purchaseService.getCountOfPurchasable(payment);
        OutputView.printPurchaseCountResult(countOfPurchasable);
        return purchaseService.purchaseLottoForCount(countOfPurchasable);
    }
    
    private LottoRanks getRanks(WinningLotto winningLotto, List<Lotto> purchasedLottos) {
        return lottoDrawService.evaluateRanks(winningLotto, purchasedLottos);
    }

    private int getWinningAmount() {
        return lottoDrawService.getWinningAmount();
    }

    private String getReturn(int payment, int winningAmount) {
        return returnService.evaluateLottoReturn(payment, winningAmount);
    }

    private void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            OutputView.printGeneratedLottoResult(lotto.getNumbers());
        }
    }

    private void displayReturnsResult(String lottoReturns) {
        OutputView.printReturnsResult(lottoReturns);
    }

    private void displayWinningResult(LottoRanks lottoRanks) {
        for (LottoRankConstants rank : LottoRankConstants.values()) {
            OutputView.printWinningLottoResult(rank, lottoRanks.getRankCount(rank));
        }
    }

}
