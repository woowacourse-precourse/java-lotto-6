package lotto.Controller;

import lotto.Model.Lotto;
import lotto.View.InputView;

import static lotto.Util.toList;

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

    public static int setBonusNumber() {
        try {
            return Integer.parseInt(InputView.bonusNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber();
        }
    }
}
