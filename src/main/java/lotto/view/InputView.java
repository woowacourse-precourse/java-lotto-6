package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        validateBlank(input);
        validateNonNumber(input);
        int amount = validateIntegerRange(input);
        return amount;
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 공백일 수 없습니다");
        }
    }

    private static void validateNonNumber(String input) {
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자 이외의 값이 들어오면 안됩니다.");
        }
    }

    private static int validateIntegerRange(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
            return parsedInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 정수 값을 입력하세요.");
        }
    }
}
