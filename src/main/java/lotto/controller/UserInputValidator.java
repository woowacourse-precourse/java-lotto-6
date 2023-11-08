package lotto.controller;

public class UserInputValidator {
    private static boolean isPositiveInteger(String str) {
        try {
            int num = Integer.parseInt(str);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static int isValidBuyingPrice(String input) {
        if (!isPositiveInteger(input)) {
            throw new IllegalArgumentException("구매 금액은 양의 정수여야 합니다.");
        }
        int buyingPrice = Integer.parseInt(input);
        if (buyingPrice % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
        }
        return buyingPrice;
    }
}
