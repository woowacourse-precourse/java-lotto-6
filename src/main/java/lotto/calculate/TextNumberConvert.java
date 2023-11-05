package lotto.calculate;

import lotto.errorchek.ErrorCheck;

public class TextNumberConvert {
    public static long MoneyConvert(String input) {
        return ErrorCheck.MoneyInput(input);
    }
}
