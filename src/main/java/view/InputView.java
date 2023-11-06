package view;

import Exception.MoneyZeroException;
import Exception.NotNumberException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        isNumber(money);
        isZero(money);
    }

    private void isNumber(String input) throws IllegalStateException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new NotNumberException();
            }
        }
    }

    private void isZero(String input) throws IllegalStateException {
        if (input.equals("0")) {
            throw new MoneyZeroException();
        }
    }
}
