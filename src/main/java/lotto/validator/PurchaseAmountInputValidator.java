package lotto.validator;

public class PurchaseAmountInputValidator implements InputValidator {

    private final static String ENTER_PURCHASE_AMOUNT_1000_WON = "구입 금액은 1,000원 단위로 입력 가능합니다.";
    private final static String ENTER_PURCHASE_AMOUNT_NUMBERS = "유효한 숫자로 입력하시길 바랍니다.";
    private final static String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";
    private final static int DIVIDE_BY_1000 = 1000;

    @Override
    public void validate(String input) {
        validateNumber(input);
        validateDivideBy1000(input);
    }

    private void validateDivideBy1000(String input) {
        if (Integer.parseInt(input) % DIVIDE_BY_1000 != 0) {
            throw new IllegalArgumentException(ENTER_PURCHASE_AMOUNT_1000_WON);
        }
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ENTER_PURCHASE_AMOUNT_NUMBERS);
        }
    }

}
