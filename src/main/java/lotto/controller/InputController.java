package lotto.controller;

import java.util.List;
import lotto.view.InputView;

public class InputController {
    public static int inputAmountUntilSuccess() {
        while (true) {
            try {
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbersUntilSuccess() {
        while (true) {
            try {
                return InputView.inputLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumberUntilSuccess() {
        while (true) {
            try {
                return InputView.inputBonusNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
