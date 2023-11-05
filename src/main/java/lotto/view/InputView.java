package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.vo.Purchase;

public class InputView {

    public static Purchase inputPurchase() {
        while (true) {
            String input = readAmount();
            try {
                return Purchase.createFromInput(input);
            } catch (IllegalArgumentException e) {
                handleError(e.getMessage());
            }
        }
    }

    private static String readAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static void handleError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
