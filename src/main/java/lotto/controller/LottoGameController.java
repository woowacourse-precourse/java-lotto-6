package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void start() {
        OutputView.printPayInputMessage();
        User user = InputView.readPayment();
        int lottoCnt = user.getLottoCnt();

        Lottos lottos = Lottos.numberOf(lottoCnt);
        printLottos(lottos, lottoCnt);

        OutputView.printWinningNumberMessage();
        WinningNumber winningNumber = InputView.readWinningNumber();
    }

    private void printLottos(Lottos lottos, int lottoCnt) {
        OutputView.printPayOutputMessage(lottoCnt);
        for (int i = 0; i < lottoCnt; ++i) {
            Lotto lotto = lottos.getLotto(i);
            OutputView.printNumbers(lotto.getNumbers());
        }
    }
}
