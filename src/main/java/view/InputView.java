package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHARSE_AMOUNT = "구입금액을 입력해 주세요.";


    public static int askPurchaseAmount() {
        System.out.println(ASK_PURCHARSE_AMOUNT);
        return validateNumber(Console.readLine().trim());
    }

    public static int validateNumber(String input) {
        return Integer.parseInt(input);
    }
}
