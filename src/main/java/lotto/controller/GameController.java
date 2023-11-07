package lotto.controller;

import static java.lang.Integer.parseInt;
import static lotto.view.message.SystemMessage.INPUT_BONUS;
import static lotto.view.message.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.view.message.SystemMessage.INPUT_WINNING_LOTTO;
import static lotto.view.message.SystemMessage.OUTPUT_PURCHASE_AMOUNT;
import static lotto.view.message.SystemMessage.OUTPUT_RATE_OF_RETURN;
import static lotto.view.message.SystemMessage.OUTPUT_RESULT;

import java.util.HashMap;
import lotto.domain.Lotto;
import lotto.domain.Referee;
import lotto.domain.Win;
import lotto.validator.BonusValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.message.RankMessage;

public class GameController {
    public void run() {
        int purchaseAmount = readPurchaseAmount();
        LottoController lottoController = new LottoController(purchaseAmount);
        printLottoAmountAndLottos(lottoController);

        Win win = new Win();
        win.setWinningLotto(readWinningLotto());
        win.setBonus(readBonus(win.getWinningLotto()));

        Referee referee = new Referee();
        referee.compare(lottoController.getLottos(), win.getWinningLotto(), win.getBonus());
        printResult(referee);
        printRateOfReturn(referee, purchaseAmount);
    }

    private static int readPurchaseAmount() {
        OutputView.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());

        while (true) {
            try {
                String purchaseAmount = InputView.read();
                PurchaseAmountValidator.validate(purchaseAmount);
                return parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void printLottoAmountAndLottos(LottoController lottoController) {
        OutputView.printMessage(String.format(OUTPUT_PURCHASE_AMOUNT.getMessage(), lottoController.getLottoAmount()));
        lottoController.printLottos();
    }

    private static String readWinningLotto() {
        OutputView.printMessage(INPUT_WINNING_LOTTO.getMessage());

        while (true) {
            try {
                String winningLotto = InputView.read();
                WinningLottoValidator.validate(winningLotto);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private static int readBonus(Lotto winningLotto) {
        OutputView.printMessage(INPUT_BONUS.getMessage());

        while (true) {
            try {
                String bonus = InputView.read();
                BonusValidator.validate(bonus, winningLotto);
                return parseInt(bonus);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void printResult(Referee referee) {
        OutputView.printMessage(OUTPUT_RESULT.getMessage());

        HashMap<Integer, Integer> result = referee.getResult();
        for (int i = 5; i > 0; i--) {
            String rankResult = String.format(RankMessage.findByRank(i).getMessage(), result.get(i));
            OutputView.printMessage(rankResult);
        }
    }

    private void printRateOfReturn(Referee referee, int purchaseAmount) {
        OutputView.printMessage(
                String.format(OUTPUT_RATE_OF_RETURN.getMessage(), referee.getRateOfReturn(purchaseAmount)));
    }
}
