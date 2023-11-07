package lotto.util;

import lotto.exception.ExceptionEnum;
import lotto.exception.LottoGameException;

public class Validate {
    public static void checkPurchaseAmountValidate(String purchaseAmount) {
        Long amount = checkLongValidate(purchaseAmount);

    }

    public static void checkWinningNumberValidate(String winningNumber) {

    }

    public static void checkBonusNumberValidate(String bonusNumber) {

    }

    public static Long checkLongValidate(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new LottoGameException(ExceptionEnum.NOT_NUMBER_EXCEPTION);
        }
    }



}
