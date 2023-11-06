package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validateInput(input);

        return Integer.parseInt(input);
    }

    private static void validateInput(String input) {
        if (isNotPositiveInteger(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private static boolean isNotPositiveInteger(String input) {
        try {
            return toInteger(input) <= 0;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
