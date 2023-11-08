package lotto.service;

import static lotto.model.ErrorMessage.*;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    /**
     * 보너스 번호일 때는 쉼표도 있으면 안 되고 숫자만 있어야 하고
     * 당첨 번호일 때는 쉼표는 있어도 되는데 !!!!
     */

    public static void isEmpty(String input) {
        System.out.println(input);
        if ((input == null || input.isBlank()) == true) {
            throw new IllegalArgumentException(BLANK_ERROR.toString());
        }
    }

    public static void isNumericInput(String input) {
        if (input.matches("[0-9]+") != true) {
            throw new IllegalArgumentException(CONTAIN_SYMBOL_ERROR.toString());
        }
    }

    public static void isNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if ((number >= MIN_NUMBER && number <= MAX_NUMBER) != true) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.toString());
        }
    }

    public static void purchasePrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_UNIT_ERROR.toString());
        }
    }
}
