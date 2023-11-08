package lotto.controller;

import static lotto.model.User.userNumListInt;

import lotto.model.Lotto;
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
                userNumListInt();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        while (true) {
            try {
                OutputView.printBonusNum();
                InputView.inputUserBonusStr();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        Lotto.rank();

        OutputView.printStats();

        OutputView.printLottoResult();

        OutputView.printRateOfReturn();
    }
}
