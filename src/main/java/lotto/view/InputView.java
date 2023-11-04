package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidNumberFormatException;
import lotto.validation.ValidateNumberFormat;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public void readInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public int inputMoney() {
        String inputMoney;
        while (true) {
            inputMoney = Console.readLine();
            try {
                validateInputMoney(inputMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(inputMoney);
    }

    private void validateInputMoney(String inputMoney) {
        ValidateNumberFormat.validate(inputMoney);
    }
}
