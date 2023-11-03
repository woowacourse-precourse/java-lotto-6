package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ExceptionMessage;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        try {
            String inputPurchaseAmount = Console.readLine();
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static String readLottoNumbers() {
        System.out.println(READ_WINNER_NUMBERS_MESSAGE);
        return Console.readLine();
    }
}
