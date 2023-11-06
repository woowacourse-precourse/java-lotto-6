package lotto.Domain;


public class LottoPurchaseAmount {
    private final static String INVALID_TYPE_MESSAGE = "[ERROR] 숫자로 이루어진 값을 입력해주세요";
    private final static String INVALID_NUMBER_MESSAGE = "[ERROR] 올바른 금액을 입력해주세요";
    private final int purchaseAmount;

    public LottoPurchaseAmount(String purchaseAmount) {
        int purchaseAmountNum = validateIsNumeric(purchaseAmount);
        validateFitPurchaseAmountCondition(purchaseAmountNum);
        this.purchaseAmount = purchaseAmountNum;
    }

    public int calculatePurchaseLottoCount() {
        return purchaseAmount / 1000;
    }

    private static int validateIsNumeric(String purchaseAmount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_TYPE_MESSAGE);
            throw new IllegalArgumentException(INVALID_TYPE_MESSAGE);
        }
    }

    private static void validateFitPurchaseAmountCondition(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            System.out.println(INVALID_NUMBER_MESSAGE);
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }
}
