package lotto.controller;

import lotto.constant.LottoResult;
import lotto.model.Budget;
import lotto.model.ProfitStats;
import lotto.model.TotalResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    public Budget createBudgetByUserInput() {
        while (true) {
            try {
                InputView.printPurchasePrompt();
                return new Budget(readLine().trim());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLotto createWinningLottoByUserInput() {
        while (true) {
            try {
                InputView.printWinningNumbersPrompt();
                String numbersStr = readLine().trim();
                InputView.printBonusNumberPrompt();
                String bonusNumberStr = readLine().trim();

                return new WinningLotto(numbersStr, bonusNumberStr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
