package lotto.exception;

import lotto.common.LottoFinalConsts;

public class LottoException implements LottoFinalConsts {

    public boolean isInputOnlyNumber(String lottoPurchase) {
        try {
            Integer.parseInt(lottoPurchase);
            return true;
        } catch (NumberFormatException e){
            System.out.printf(ERROR_MESSAGE_FORMAT, LOTTO_ERROR_MESSAGE, LOTTO_NOT_VALID_LOTTOPURCHASE);
        }
        return false;
    }

    public void validateStringSplited(String winningNumbers){
        if (!winningNumbers.contains(",")) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE+LOTTO_CANNOT_SPLIT_WINNING);
        }
    }

}
