package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Constants;

public class PriceInputHandler {

    private static final int ZERO = 0;
    private static final int PURCHASE_MIN = 1000;
    private static final int PURCHASE_MAX = 1000000000;

    public int dividePaymentIntoLottoPrice() {
        System.out.println(RequestPrompt.PURCHASE_REQUEST.message);
        int payment = handleInputToPayment();
        return payment / Constants.LOTTO_PRICE;
    }

    private int handleInputToPayment() {
        boolean isInputInvalid = true;
        int result = 0;

        while (isInputInvalid) {
            try {
                String input = Console.readLine();
                result = parsePayment(input);
                isInputInvalid = false;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorPrompt.PURCHASE_ERROR.message);
            }
        }
        return result;
    }

    private int parsePayment(String input) {
        int price = Integer.parseInt(input.trim());
        validateRange(price, PURCHASE_MIN, PURCHASE_MAX);
        validateUnit(price);
        return price;
    }

    private void validateRange(int target, int start, int end) {
        if (target < start || target > end) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int price) {
        if ((price % Constants.LOTTO_PRICE) != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
