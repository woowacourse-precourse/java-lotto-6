package lotto.util;

import lotto.model.LottoMoneyValidator;

public class Utils {
    public static int parseInt(String input) {
        LottoMoneyValidator.validateInputString(input);
        return Integer.parseInt(input);
    }
}
