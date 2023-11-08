package lotto.Controller;

import lotto.Model.Lotto;
import lotto.View.InputView;
import static lotto.Constants.*;
import static lotto.Util.*;

public class InputController {
    public static int setLottoCount() {
        try {
            return Integer.parseInt(InputView.purchaseAmountInput()) / (int)PRICE_OF_LOTTO;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
        return setLottoCount();
    }
    public static Lotto setLotto() {
        try {
            return toLotto(InputView.winningNumbersInput());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int setBonusNumber() {
        try {
            return Integer.parseInt(InputView.bonusNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
        return setBonusNumber();
    }
}
