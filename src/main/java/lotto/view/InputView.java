package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputNumber(String inputMessage) {
        printInputMessage(inputMessage);
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
