package view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private static final String PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String setUserPayment() {
        System.out.println(PAYMENT_MESSAGE);
        String userInput = Console.readLine();
        removeBlank(userInput);
        removeComma(userInput);
        return userInput;
    }

    private static String removeComma(String userInput) {
        return userInput.replace(",", "");
    }

    private static String removeBlank(String userInput) {
        return userInput.replace(" ", "");
    }

    public static String setWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        removeBlank(userInput);
        return userInput;
    }
}
