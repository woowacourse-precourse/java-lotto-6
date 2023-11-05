package lotto.validator;

import lotto.common.message.ExceptionMessage;
import lotto.common.utils.RegexpUtil;

public class InputValidator {

    public static final int LOTTO_PRICE = 1000;
    public static final int FIRST_INDEX = 0;
    public static final int ZERO = 0;

    public boolean validateInputPrice(String inputPrice) {
        if (!inputPrice.matches(RegexpUtil.ONLY_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMBER_CHECK);
        }
        if (Integer.parseInt(inputPrice) == ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_CHECK);
        }
        if (Integer.parseInt(String.valueOf(inputPrice.charAt(FIRST_INDEX))) == ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.START_ZERO_CHECK);
        }
        return Integer.parseInt(inputPrice) % LOTTO_PRICE != ZERO;
    }

}
