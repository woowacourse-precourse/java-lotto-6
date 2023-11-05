package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

public class InputView {
    private static final String USER_INPUT_BUY_ACCOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int getUserInputForLottoBuyAccount() {
        System.out.println(USER_INPUT_BUY_ACCOUNT_MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        Validation.validateIsNotNumber(userInput);
        return convertStringToInt(userInput);
    }

    private static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
