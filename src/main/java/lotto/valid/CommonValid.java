package lotto.valid;

import static lotto.consts.ErrorMsgConst.ERROR_NOT_BLANK;
import static lotto.consts.ErrorMsgConst.ERROR_ONLY_NUMBER;

public class CommonValid {

    public static int validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        return Integer.parseInt(input);
    }

    public static void validNotBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ERROR_NOT_BLANK);
        }
    }
}
