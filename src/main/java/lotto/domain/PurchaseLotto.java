package lotto.domain;

import lotto.constant.LottoConfig;

import static lotto.constant.ErrorMessage.*;

public class PurchaseLotto {
    public static int getLottoCount(String amount) {
        validator(amount);
        int amountNum = Integer.parseInt(amount);
        return amountNum / 1000;
    }

    public static void validator(String amount){
        validateSpace(amount);
        validateNumber(amount);
        validateFirstNumber(amount);
        validateMultipleOf1000(amount);
        validateMaxPurchase(amount);
    }

    private static void validateSpace(String amount) {
        if(amount.contains(" ")){
            throw new IllegalArgumentException(ERROR_CONTAIN_SPACE.toString());
        }
    }

    private static void validateNumber(String amount) {
        if (!isNumeric(amount)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER.toString());
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static void validateFirstNumber(String amount) {
        int firstNumber = amount.charAt(0) - '0';
        if(firstNumber == LottoConfig.NUMBER_ZERO){
            throw new IllegalArgumentException(ERROR_NOT_FIRST_ZERO.toString());
        }
    }

    private static void validateMultipleOf1000(String amount) {
        int amountNum = Integer.parseInt(amount);
        if(amountNum % LottoConfig.PURCHASE_AMOUNT_UNIT != LottoConfig.NUMBER_ZERO){
            throw new IllegalArgumentException(ERROR_NOT_UNIT.toString());
        }
    }

    private static void validateMaxPurchase(String amount) {
        int amountNum = Integer.parseInt(amount);
        if(amountNum > LottoConfig.PURCHASE_AMOUNT_MAX){
            throw new IllegalArgumentException(ERROR_OVER_MAX.toString());
        }
    }
}
