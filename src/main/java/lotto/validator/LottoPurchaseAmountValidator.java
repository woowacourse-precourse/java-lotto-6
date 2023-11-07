package lotto.validator;

import lotto.GameDetail;
import lotto.exception.PurchaseAmountExceptionMessage;

/**
 * 로또 구입 금액 검증 클래스
 */
public class LottoPurchaseAmountValidator implements AmountValidator {

    /**
     * 입력한 구입금액이 유효한지 검증
     * @param input 입력한 구입금액
     * @return 유효한 금액인지 여부
     */
    @Override
    public boolean isValid(String input) throws IllegalArgumentException {
        if (!isPositiveNumber(input)) {
            throw new IllegalArgumentException(String.format("%s = %s", PurchaseAmountExceptionMessage.NOT_POSITIVE_NUMBER, input));
        }

        int purchaseAmount = Integer.parseInt(input);

        if (!isMultipleOf1000(purchaseAmount)) {
            throw new IllegalArgumentException(String.format("%s = %s", PurchaseAmountExceptionMessage.NOT_MULTIPLE_OF_1000, input));
        }

        return true;
    }

    /**
     * 입력값이 1000원 단위인지 검증
     */
    private static boolean isMultipleOf1000(int purchaseAmount) {
        return purchaseAmount % GameDetail.AMOUNT_UNIT == 0;
    }

    /**
     * 입력값이 양수인지 검증
     * @param input 입력값
     * @return 양수이면 true, 그렇지 않으면 false
     */
    private static boolean isPositiveNumber(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return num > 0;
    }

}
