package lotto.Util;

import java.util.List;

public class Validation {

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void isValidUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = parseInteger(input);
        isValidUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> validateWinnerNumbers(String input) {

    }

    public static int validateBonusNumber(String input) {

    }
}
