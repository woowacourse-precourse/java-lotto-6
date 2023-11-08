package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorMsg;
import lotto.enums.InputMsg;

public class InputView {
    public String purchaseAmount() {
        System.out.println(InputMsg.PURCHASE_AMOUNT.getMsg());
        return input();
    }

    public String winningNumbers() {
        System.out.println(InputMsg.WINNING_NUMBER.getMsg());
        return input();
    }

    public String bonusNumber() {
        System.out.println(InputMsg.BONUS_NUMBER.getMsg());
        return input();
    }

    private String input() {
        String input = Console.readLine();
        validate(input);
        return input;
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_NO_INPUT.getErrMsg());
        }
    }
}
