package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumConstant;

public class PurchaseAmountValidator extends Validator {

    @Override
    public void validate(String purchaseAmount) {
        validateEmptyInput(purchaseAmount);
        validatePurchaseAmount(purchaseAmount);
    }
    // 금액이 숫자가 아닌 문자가 들어온 경우
    private static void validatePurchaseAmount(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }

    // 구매금액이 1000원 이상인지 확인하는 메서드
    public static boolean isOverMinPurchaseAmount(Integer purchaseAmount) {
        return purchaseAmount >= LottoNumConstant.LOTTO_AMOUNT_UNIT.getValue();
    }

    // 금액이 1000원 단위인지 확인하는 메서드 -> ClientInform에서 체크
    public static boolean isThousandWonAmount(Integer purchaseAmount) {
        return purchaseAmount % LottoNumConstant.LOTTO_AMOUNT_UNIT.getValue() == LottoNumConstant.ZERO.getValue();
    }
}
