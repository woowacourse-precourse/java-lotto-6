package lotto.controller;

import java.util.List;
import lotto.constants.LottoRankConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoRanks;
import lotto.domain.WinningLotto;
import lotto.service.LottoDrawService;
import lotto.service.PurchaseService;
import lotto.service.ReturnService;
import lotto.view.InputView;
import lotto.view.OutputView;

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

    private int getPurchaseAmount() {
        OutputView.printMessage(OutputView.INPUT_AMOUNT_MESSAGE);
        return InputView.inputPurchaseAmount();
    }

    private Lotto getWinningLotto() {
        OutputView.newLine();
        OutputView.printMessage(OutputView.INPUT_WINNING_NUMBERS_MESSAGE);
        return new Lotto(InputView.inputWinningNumbers());
    }

    private int getBonusNumber(Lotto winningLotto) {
        OutputView.newLine();
        OutputView.printMessage(OutputView.INPUT_BONUS_NUMBER_MESSAGE);
        return InputView.inputBonusNumber(winningLotto);
    }

    private List<Lotto> purchaseLotto(int payment) {
        int countOfPurchasable = purchaseService.getCountOfPurchasable(payment);
        OutputView.newLine();
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
        OutputView.newLine();
        OutputView.printMessage(OutputView.STATISTICS_MESSAGE);
        for (LottoRankConstants rank : LottoRankConstants.values()) {
            OutputView.printWinningLottoResult(rank, lottoRanks.getRankCount(rank));
        }
    }

}
