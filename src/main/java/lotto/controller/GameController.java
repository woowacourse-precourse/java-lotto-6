package lotto.controller;

import static lotto.view.SystemMessage.INPUT_BONUS;
import static lotto.view.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.view.SystemMessage.INPUT_WINNING_LOTTO;
import static lotto.view.SystemMessage.OUTPUT_PURCHASE_AMOUNT;

import lotto.domain.Referee;
import lotto.domain.Win;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public void run() {
        LottoController lottoController = new LottoController(readPurchaseAmount());
        printLottoAmountAndLottos(lottoController);

        Win win = new Win();
        win.setWinningLotto(readWinningLotto());
        win.setBonus(readBonus());

        Referee referee = new Referee();
        referee.compare(lottoController.getLottos(), win.getWinningLotto(), win.getBonus());
    }

    private void printLottoAmountAndLottos(LottoController lottoController) {
        OutputView.printMessage(String.format(OUTPUT_PURCHASE_AMOUNT.getMessage(), lottoController.getLottoAmount()));
        lottoController.printLottos();
    }

    private static int readPurchaseAmount() {
        OutputView.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        return Integer.parseInt(InputView.read());
    }

    private static String readWinningLotto() {
        OutputView.printMessage(INPUT_WINNING_LOTTO.getMessage());
        return InputView.read();
    }

    private static int readBonus() {
        OutputView.printMessage(INPUT_BONUS.getMessage());
        return Integer.parseInt(InputView.read());
    }
}
