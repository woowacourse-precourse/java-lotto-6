package lotto.Controller;

import lotto.Model.Lotto;
import lotto.View.InputView;

import static lotto.Util.toList;
import lotto.View.InputView;

public class InputController {
    public static int setLottoCount() {
        try {
            return Integer.parseInt(InputView.purchaseAmountInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLottoCount();
        }
    }
    public static Lotto setLotto() {
        try {
            return new Lotto(toList(InputView.winningNumbersInput()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int setBounsNumber() {
        try {
            return Integer.parseInt(InputView.bounsNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBounsNumber();
        }
    }
}
