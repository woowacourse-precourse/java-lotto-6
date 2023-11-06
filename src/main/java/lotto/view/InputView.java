package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            ErrorMessage.printNonNumericAmountError();
            return inputPurchaseAmount();
        }
    }
}
