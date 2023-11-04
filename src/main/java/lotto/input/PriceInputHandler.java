package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.AppConfig;

public class PriceInputHandler {

    private static final int ZERO = 0;
    private static final int MIN_PRICE_UNIT = 1000;
    private static final int PURCHASE_MIN = 1000;
    private static final int PURCHASE_MAX = 100000;

    public int dividePaymentIntoLottoPrice() {
        String input = Console.readLine();
        System.out.println("구입금액을 입력해 주세요.");
        int price = validatePrice(input);
        return price / AppConfig.LOTTO_PRICE;
    }

    public static int validatePrice(String input) {
        try {
            int price = convertInteger(input);
            validateRange(price, PURCHASE_MIN, PURCHASE_MAX);
            validateUnit(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 지불할 금액을 다시 입력해주세요.");
            String newInput = Console.readLine();
            return validatePrice(newInput);
        }
    }

    private static int convertInteger(String input) {
        return Integer.parseInt(input);
    }

    private static void validateRange(int target, int start, int end) {
        if (target < start || target > end) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateUnit(int price) {
        if ((price % MIN_PRICE_UNIT) != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
