package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String getUserInput() {
        return Console.readLine();
    }

    public static PurchasePrice inputPurchasePrice() {
        System.out.println("구입 금액을 입력해주세요.");
        try {
            String userInput = getUserInput();
            int userIntegerInput = Integer.parseInt(userInput);
            return new PurchasePrice(userIntegerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수로 입력해주세요.");
        }
    }
}
