package lotto.controller;

import java.util.List;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

    private static final InputView inputView = new InputView();

    public static int inputAmountUntilSuccess() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbersUntilSuccess() {
        while (true) {
            try {
                return inputView.inputLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumberUntilSuccess() {
        while (true) {
            try {
                return inputView.inputBonusNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
