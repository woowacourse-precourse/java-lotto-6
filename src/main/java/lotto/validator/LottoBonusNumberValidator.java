package lotto.validator;

import lotto.common.message.ExceptionMessage;
import lotto.common.utils.RegexpUtil;

public class LottoBonusNumberValidator {

    public static final int LOTTO_PRICE = 1000;
    public static final int FIRST_INDEX = 0;
    public static final int ZERO = 0;

    public void validateInputWinnerNumber(String number) {
        number = number.replaceAll("[,\\s]", "");
        if (!number.matches(RegexpUtil.ONLY_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMBER_CHECK);
        }
        if (Integer.parseInt(number) == ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_CHECK);
        }
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException(ExceptionMessage.WINNER_NUMBER_RANGE_CHECK);
        }
        if(number.trim().isEmpty() || number.trim().isBlank()){
            throw new IllegalArgumentException((ExceptionMessage.WINNER_NUMBER_BLANK_CHECK));
        }
    }

}
