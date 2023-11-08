package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class SystemMoneyInput {

    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String BLANK_ERROR = "입력된 값이 없습니다. 다시 입력해주세요.";
    private static final String DIVISION_ERROR = "금액은 1000으로 나눠 떨어져야 합니다.";
    private static final Integer THOUSANDS = 1000;
    public static int readMoney() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String purchaseAmount = Console.readLine();
        try {
            validateMoney(purchaseAmount);
        }
        catch (IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
            readMoney();
        }

        return Integer.parseInt(purchaseAmount);
    }

    public static void validateMoney(String purchase) {
        validateNone(purchase);
        validateDivision(purchase);
    }

    public static void validateNone(String purchase) {
        if (purchase.length() == 0) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public static void validateDivision(String purchase) {
        int money = Integer.parseInt(purchase);
        if (money % THOUSANDS != 0) {
            throw new IllegalArgumentException(DIVISION_ERROR);
        }
    }
}
