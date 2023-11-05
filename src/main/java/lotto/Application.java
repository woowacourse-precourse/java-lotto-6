package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println(InputMessage.purchaseAmount);
        String purchaseAmount = Console.readLine();
    }

    public void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_VALUE);
        }
    }

    public void checkNumber(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }
}
