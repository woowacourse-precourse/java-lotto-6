package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constants.WinningResult;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoStore lottoStore = new LottoStore();
    private List<Lotto> purchaseLottoList;

    public void start() {
        try {
            InputPurchaseAmount();
            OutputView.printLottoList(purchaseLottoList);
            inputNumbers();
            printLottoResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void InputPurchaseAmount() {
        try {
            OutputView.askPurchaseAmount();
            int purchaseAmount = InputView.inputPurchaseAmount();
            purchaseLottoList = lottoStore.buyLottos(purchaseAmount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void inputNumbers() {
        try {
            OutputView.askWinningNumbers();
            Lotto lotto = new Lotto(InputView.inputWinningNumbers());
            OutputView.askBonusNumber();
            Integer bonusNumber = InputView.inputBonusNumber(lotto.getNumbers());
            WinLotto compareResult = new WinLotto(lotto, bonusNumber);
            lottoStore.setCompareList(compareResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottoResult() {
        try {
            Map<WinningResult, Integer> winningLottoResult = lottoStore.getLottoResult();
            double profitRate = 0;
            OutputView.printResult(winningLottoResult);
            for (WinningResult winningResult : winningLottoResult.keySet()) {
                profitRate
                        += (
                        (double) (winningResult.getPrize()) / lottoStore.getPurchaseAmount()
                                * (winningLottoResult.get(
                                winningResult)) * (100));

            }
            OutputView.printProfitRate(profitRate);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
