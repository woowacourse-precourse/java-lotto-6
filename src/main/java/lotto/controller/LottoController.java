package lotto.controller;

import java.util.List;
import lotto.domain.amount.PurchaseAmount;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoStatistic;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.LottosResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final LottoStatistic lottoStatistic;

    public LottoController() {
        this.lottoMachine = LottoMachine.initial();
        this.lottoStatistic = LottoStatistic.initial();
    }

    public void run() {
        PurchaseAmount purchaseAmount = receivePurchaseAmount();
        Lottos lottos = lottoMachine.purchaseLottos(purchaseAmount);

        OutputView.printLottoCount(lottos.size());
        OutputView.printLottos(LottosResponse.from(lottos));

        WinningLotto winningLotto = receiveWinningLotto();

        lottoStatistic.calculateWinningStatistics(lottos, winningLotto);
        lottoStatistic.calculateEarningRate(purchaseAmount);

        OutputView.printLottoStatistic(lottoStatistic.createStatisticResponse());
    }

    private PurchaseAmount receivePurchaseAmount() {
        try {
            int amount = InputView.readPurchaseAmount();
            return PurchaseAmount.from(amount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receivePurchaseAmount();
        }
    }

    private List<Integer> receiveWinningNumbers() {
        try {
            return InputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveWinningNumbers();
        }
    }

    private int receiveBonusNumber() {
        try {
            return InputView.readBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveBonusNumber();
        }
    }

    private WinningLotto receiveWinningLotto() {
        try {
            List<Integer> winningNumbers = InputView.readWinningNumbers();
            int bonusNumber = InputView.readBonusNumber();
            return WinningLotto.of(winningNumbers, BonusNumber.from(bonusNumber));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveWinningLotto();
        }
    }
}
