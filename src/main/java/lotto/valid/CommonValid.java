package lotto.valid;

import static lotto.consts.ErrorMsgConst.ERROR_ONLY_NUMBER;

public class CommonValid {

    public static int validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        return Integer.parseInt(input);
    }
}
