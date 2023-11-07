package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Constants;

public class PriceInputHandler {

    private static final int ZERO = 0;
    private static final int PURCHASE_MIN = 1000;
    private static final int PURCHASE_MAX = 1000000000;

    public int divideRequestPaymentIntoLottoPrice() {
        System.out.println(RequestPrompt.PURCHASE_REQUEST.message);
        int payment = handleInputToPayment();
        return payment / Constants.LOTTO_PRICE;
    }

    private int handleInputToPayment() {
        boolean isInputInvalid = true;
        int result = 0;

        do {
            try {
                result = parseInputToPayment();
                isInputInvalid = false;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorPrompt.PURCHASE_ERROR.message);
            }
        } while (isInputInvalid);
        return result;
    }

    private int parseInputToPayment() {
        String input = Console.readLine();
        int payment = Integer.parseInt(input.trim());
        validateRange(payment);
        validateUnit(payment);
        return payment;
    }

    private void validateRange(int target) {
        if (target < PURCHASE_MIN || target > PURCHASE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int price) {
        if ((price % Constants.LOTTO_PRICE) != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
