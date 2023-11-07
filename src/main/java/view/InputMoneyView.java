package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Money;
import exception.InvalidMoneyFormatException;

public class InputMoneyView {
    private static final String INTEGER_REGEX = "^\\d+$";
    private static final String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final int ZERO = 0;

    public int getValue() {
        System.out.println(MONEY_MESSAGE);
        String money = Console.readLine();

        validate(money);

        return Integer.parseInt(money);
    }

    public void validate(String inputValue) {
        validateNonNumeric(inputValue);
    }

    public void validateNonNumeric(String inputValue) {
        if (!inputValue.matches(INTEGER_REGEX)) {
            throw new InvalidMoneyFormatException();
        }
    }
}
