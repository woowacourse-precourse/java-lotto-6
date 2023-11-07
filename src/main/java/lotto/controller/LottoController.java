package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoOrder;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private LottoOrder lottoOrder;
    private WinningLotto winningLotto;

    public LottoController() {
    }

    public void buyLotto() {
        try {
            int purchasePrice = LottoInputView.inputPurchasePrice();
            lottoOrder = LottoOrder.orderAutoLotto(purchasePrice);
        } catch (IllegalArgumentException e) {
            LottoOutputView.printErrorMessage(e.getMessage());
            buyLotto();
        }
    }

    public void readboughtLotto() {
        int lottoCount = lottoOrder.getLottoCount();
        LottoOutputView.printLottoCount(lottoCount);

        List<List<Integer>> lottoNumbers = lottoOrder.getLottoNumbers();
        LottoOutputView.printLottoNumbers(lottoNumbers);
    }

    public void setupWinningLotto() {
        Lotto lotto = getLotto();
        winningLotto = createWinningLotto(lotto);
    }

    public void processWinningResult() {
        List<Long> countByAllRank = lottoOrder.calculateCountByAllRank(winningLotto);
        double gainRatio = lottoOrder.calculateGainRatio(winningLotto);
        LottoOutputView.printWinningStatistics(countByAllRank, gainRatio);
    }

    private Lotto getLotto() {
        try {
            List<Integer> numbers = LottoInputView.inputWinningLottoNumbers();
            return LottoGenerator.manualGenerate(numbers);
        } catch (IllegalArgumentException e) {
            LottoOutputView.printErrorMessage(e.getMessage());
            return getLotto();
        }
    }

    private WinningLotto createWinningLotto(Lotto lotto) {
        try {
            int bonusNumber = LottoInputView.inputBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            LottoOutputView.printErrorMessage(e.getMessage());
            return createWinningLotto(lotto);
        }
    }

}
