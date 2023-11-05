package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static int getPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();

        try {
            return InputValidator.validateNumber(input);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getPurchaseMoney();
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}