package lotto.ui;

import static lotto.global.LottoInformation.LOTTO_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_PRICE_INPUT = "구입금액을 입력해 주세요.";
    private static final String INVALID_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 자연수여야 합니다.";
    private static final String INVALID_PRICE_UNIT_ERROR = "[ERROR] 1,000원 단위로 입력해야 합니다.";
    private static final int ZERO = 0;

    public static int getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT);
        String userInput = Console.readLine();
        validPurchasePrice(userInput);
        return StringToInt(userInput);
    }

    private static void validPurchasePrice(String userInput) {
        checkInteger(userInput);
        checkNaturalNumber(userInput);
        checkPurchaseAmount(userInput);
    }

    private static void checkInteger(String userInput) {
        try {
            StringToInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR);
        }
    }

    private static void checkNaturalNumber(String userInput) {
        if (StringToInt(userInput) <= ZERO) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR);
        }
    }

    private static void checkPurchaseAmount(String userInput) {
        int price = StringToInt(userInput);
        if (price % LOTTO_PRICE_UNIT.getValue() != ZERO) {
            throw new IllegalArgumentException(INVALID_PRICE_UNIT_ERROR);
        }
    }

    private static int StringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
