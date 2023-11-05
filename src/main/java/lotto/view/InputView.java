package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        validateBlank(input);
        int parsedInput = Integer.parseInt(input);
        return parsedInput;
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 공백일 수 없습니다");
        }
    }

}
