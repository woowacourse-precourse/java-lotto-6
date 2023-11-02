package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
        try {
            return getInteger();
        } catch (IllegalArgumentException exception) {
            return getInteger();
        }
    }

    private int getInteger() throws IllegalArgumentException{
        String read = Console.readLine();
        validateIsNumber(read);
        return Integer.parseInt(read);
    }

    private void validateIsNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다");
        }
    }
}
