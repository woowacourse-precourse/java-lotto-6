package study.prototype;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.AppConfig;

class PriceInputHandlerPrototype {
    private static final int ZERO = 0;
    private static final int PURCHASE_MIN = 1000;
    private static final int PURCHASE_MAX = 100000;
    private static final String PURCHASE_INFO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_ERROR_MESSAGE = "[ERROR] 지불할 금액을 다시 입력해주세요.";

    private int dividePaymentIntoLottoPrice() {
        System.out.println(PURCHASE_INFO_MESSAGE);
        String input = Console.readLine();
        int price = validatePrice(input);
        return price / AppConfig.LOTTO_PRICE;
    }

    private int validatePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            validateRange(price, PURCHASE_MIN, PURCHASE_MAX);
            validateUnit(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(PURCHASE_ERROR_MESSAGE);
            String newInput = Console.readLine();
            return validatePrice(newInput);
        }
    }

    private void validateRange(int target, int start, int end) {
        if (target < start || target > end) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int price) {
        if ((price % AppConfig.LOTTO_PRICE) != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
