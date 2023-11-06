package lotto.Controller;

import lotto.domian.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        start();
    }

    private void start() {
        long lottoAmount = inputLottoAmount();
        OutputView.printLottoAmount(lottoAmount);
    }

    private long inputLottoAmount() {
        LottoAmount lottoAmountCount = new LottoAmount(InputView.inputAmount());
        return lottoAmountCount.calculateLottoAmount();
    }
}
