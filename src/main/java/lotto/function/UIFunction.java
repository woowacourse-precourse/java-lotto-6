package lotto.function;

import camp.nextstep.edu.missionutils.Console;

public class UIFunction {
    public static String requestInput(String requestMessage) {
        System.out.println(requestMessage);
        String userInput = Console.readLine().trim();
        validateEmpty(userInput);
        return userInput;
    }

    public static void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }
}
