package lotto.exception;

import lotto.common.LottoFinalConsts;

public class LottoException implements LottoFinalConsts {

    public boolean isValidLottoPurchase(String lottoPurchase) {
        try {
            Integer.parseInt(lottoPurchase);
            return true;
        } catch (NumberFormatException e){
            System.out.printf("%s %s", LOTTO_ERROR_MESSAGE, LOTTO_NOT_VALID_LOTTOPURCHASE);
            throw new IllegalArgumentException();
        }
    }
}
