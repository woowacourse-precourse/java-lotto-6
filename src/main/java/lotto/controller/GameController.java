package lotto.controller;

import lotto.view.OutputView;

public class GameController {
    public void run() {
        while (true) {
            try {
                OutputView.printLottoBuyPrice();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        OutputView.printBoughtNum();

        OutputView.printLotto();

        while (true) {
            try {
                OutputView.printUserNum();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        while (true) {
            try {
                OutputView.printBonusNum();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        OutputView.printStats();

        OutputView.printLottoResult();

        OutputView.printRateOfReturn();
    }
}
