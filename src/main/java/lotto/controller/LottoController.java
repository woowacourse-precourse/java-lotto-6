package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoOrder;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    public LottoController() {
    }

    public void play() {
        LottoOrder lottoOrder = createLottoOrder();
        printLottoOrderInfo(lottoOrder);

        WinningLotto winningLotto = createWinningLotto();

        processWinningStatistics(lottoOrder, winningLotto);
    }

    private LottoOrder createLottoOrder() {
        try {
            int purchasePrice = LottoInputView.inputPurchasePrice();
            return LottoOrder.orderAutoLotto(purchasePrice);
        } catch (IllegalArgumentException e) {
            LottoOutputView.printErrorMessage(e.getMessage());
            return createLottoOrder();
        }
    }

    private void printLottoOrderInfo(LottoOrder lottoOrder) {
        int lottoCount = lottoOrder.getLottoCount();
        LottoOutputView.printLottoCount(lottoCount);

        List<List<Integer>> lottoNumbers = lottoOrder.getLottoNumbers();
        LottoOutputView.printLottoNumbers(lottoNumbers);
    }

    private WinningLotto createWinningLotto() {
        try {
            List<Integer> numbers = LottoInputView.inputWinningLottoNumbers();
            Lotto winningLotto = LottoGenerator.manualGenerate(numbers);
            int bonusNumber = LottoInputView.inputBonusNumber();
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            LottoOutputView.printErrorMessage(e.getMessage());
            return createWinningLotto();
        }
    }

    private void processWinningStatistics(LottoOrder lottoOrder, WinningLotto winningLotto) {
        List<Long> countByAllRank = lottoOrder.calculateCountByAllRank(winningLotto);
        double gainRatio = lottoOrder.calculateGainRatio(winningLotto);
        LottoOutputView.printWinningStatistics(countByAllRank, gainRatio);
    }

}
