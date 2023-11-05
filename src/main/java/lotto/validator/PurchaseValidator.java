package lotto.validator;

import lotto.view.ErrorMessage;

public class PurchaseValidator {
    public static void validateIntegerInput(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount); // 입력값은 정수입니다.
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT); // 입력값은 정수가 아닙니다.
        }
    }

    public static void validateIsDivisible(int purchaseAmount) {
        if(purchaseAmount%1000!=0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIVIDE);
        }
    }
}
