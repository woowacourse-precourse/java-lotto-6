package lotto.controller;

import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public void run() {
        while (true) {
            try {
                OutputView.printLottoBuyPrice();
                InputView.inputLottoBought();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        OutputView.printBoughtNum();

        OutputView.printLotto();

        while (true) {
            try {
                OutputView.printUserNum();
                InputView.inputUserNum();
                User.userNumListInt();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        while (true) {
            try {
                OutputView.printBonusNum();
                InputView.inputUserBonusStr();
                User.userBonusNum();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        OutputView.printStats();

        OutputView.printLottoResult();

        OutputView.printRateOfReturn();
    }
}
