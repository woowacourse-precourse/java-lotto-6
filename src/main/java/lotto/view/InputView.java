package lotto.view;

import lotto.util.InputUtil;

import java.util.List;

import static lotto.constant.SystemConstant.*;

public class InputView {

    public int inputMoney() {
        System.out.print(INPUT_MONEY_MESSAGE.getMessage());
        return InputUtil.inputNumber();
    }

    public List<Integer> inputWinningNumber() {
        System.out.println();
        System.out.print(INPUT_WINNING_NUMBER_MESSAGE.getMessage());
        return InputUtil.inputNumbers();
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.print(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        return InputUtil.inputNumber();
    }
}
