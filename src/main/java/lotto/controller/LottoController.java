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
        try {
            PurchaseAmount purchaseAmount = receivePurchaseAmount();
            Lottos lottos = purchaseLottos(purchaseAmount);
            WinningLotto winningLotto = receiveWinningLotto();
            computeStatistics(lottos, winningLotto, purchaseAmount);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
    }

    private PurchaseAmount receivePurchaseAmount() {
        while (true) {
            try {
                int amount = InputView.readPurchaseAmount();
                return PurchaseAmount.from(amount);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = lottoMachine.purchaseLottos(purchaseAmount);
        OutputView.printLottoCount(lottos.size());
        OutputView.printLottos(LottosResponse.from(lottos));
        return lottos;
    }

    private WinningLotto receiveWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = receiveWinningNumbers();
                int bonusNumber = receiveBonusNumber();
                return WinningLotto.of(winningNumbers, BonusNumber.from(bonusNumber));
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> receiveWinningNumbers() {
        while (true) {
            try {
                return InputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }


    private int receiveBonusNumber() {
        while (true) {
            try {
                return InputView.readBonusNumber();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void computeStatistics(Lottos lottos, WinningLotto winningLotto,
        PurchaseAmount purchaseAmount) {
        lottoStatistic.calculateWinningStatistics(lottos, winningLotto);
        lottoStatistic.calculateEarningRate(purchaseAmount);
        OutputView.printLottoStatistic(lottoStatistic.createStatisticResponse());
    }
}