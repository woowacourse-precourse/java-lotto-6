package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String ERROR_INPUT_IS_NOT_NUMBER = "숫자만 입력 가능합니다.";

    private InputView() {
    }

    public static int inputLottoPurchaseMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);
        return getUserNumberInput();
    }

    private static int getUserNumberInput() {
        String userInput = Console.readLine();
        validateUserNumberInput(userInput);
        return Integer.parseInt(userInput);
    }

    private static void validateUserNumberInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_INPUT_IS_NOT_NUMBER);
        }
    }
}
