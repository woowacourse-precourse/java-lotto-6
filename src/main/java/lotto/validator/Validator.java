package lotto.validator;

public class Validator {

    public static void purchaseAmount(String inputPurchaseAmount) {
        if (isNotInteger(inputPurchaseAmount)) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        if (isPurchaseAmountZero(purchaseAmount)) {
            throw new IllegalArgumentException("최소 구매가격은 1000원 입니다.");
        }

        if (isNotDivisionForPrice(purchaseAmount)) {
            throw new IllegalArgumentException("1000원 단위로만 입력이 가능합니다.");
        }
    }

    private static boolean isPurchaseAmountZero(int purchaseAmount) {
        return purchaseAmount == 0;
    }

    private static boolean isNotDivisionForPrice(int purchaseAmount) {
        return ((double) purchaseAmount / 1000) != (purchaseAmount / 1000);
    }

    private static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
