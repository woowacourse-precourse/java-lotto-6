package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ExceptionMessage;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        try {
            String inputPurchaseAmount = Console.readLine();
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }
}
