package lotto.controller;

import java.util.List;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private int inputMoney() {
        while (true) {
            try {
                OutputView.printPurchaseAmountMessage();
                int purchaseAmount = InputView.inputPurchaseAmount();
                validateMoney(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                OutputView.printWinningNumbersMessage();
                List<Integer> integers = InputView.inputWinningNumbers();

                System.out.println();
                OutputView.printBonusNumberMessage();
                int bonus = InputView.inputPurchaseAmount();
                return new WinningNumbers(integers, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }
}
