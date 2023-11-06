package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String userInput=Console.readLine().trim();
        System.out.println();
        return validateNumber(userInput);
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }
}
