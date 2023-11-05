package lotto.view;

import lotto.constant.InputMessage;
import lotto.util.InputUtil;

public class InputView {
    public String inputMoney() {
        System.out.println(InputMessage
                .REQUEST_MONEY_MESSAGE.getMessage());
        return InputUtil.readInput();
    }

    public String readLotto() {
        System.out.println(InputMessage
                .REQUEST_WINNING_NUMBERS_MESSAGE.getMessage());
        return InputUtil.readInput();
    }

    public String readBonusNumber() {
        System.out.println(InputMessage
                .REQUEST_BONUS_NUMBER_MESSAGE.getMessage());
        return InputUtil.readInput();
    }
}
