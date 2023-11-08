package validate;

public class GeneralExceptionHandler {

    public static final String EMPTY_ERROR_MESSAGE = "[ERROR] 입력한 값이 존재하지 않습니다.";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 값이 숫자가 아닙니다.";
    public static final String PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE = "=[ERROR] 구매 금액이 1000원 미만입니다.";
    public static final String PURCHASE_AMOUNT_NOT_DIVIDE_ERROR_MESSAGE = "[ERROR] 구매금액이 천원 단위가 아닙니다.";

    private int UserPurchaseAmount() {
        try {

        } catch (IllegalArgumentException e) {

        }

    }

    public static int validateNumberExceptionHandler(String inputStr) {
        validateEmpty(inputStr);
        return validateNumber(inputStr);
    }

    public static void validateEmpty(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static int validateNumber(String inputStr) {
        try {
            int returnNumber = Integer.parseInt(inputStr);
            return returnNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateMinimumPurchaseAmount(int userPurchaseAmount) {
        if (userPurchaseAmount < 1000) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE);
        }
    }

    public static void validateNotDividePurchaseAmount(int userPurchaseAmount) {
        if (userPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVIDE_ERROR_MESSAGE);
        }
    }
}
