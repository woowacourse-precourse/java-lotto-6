package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_LOTTO_BUY_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";

    public static int inputNumber() {
        printInputMessage(INPUT_LOTTO_BUY_PRICE_MESSAGE);
        String inputValue = Console.readLine();

        return parseNumber(inputValue);
    }

    private static void printInputMessage(String inputMessage) {
        System.out.println(inputMessage);
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }
}
