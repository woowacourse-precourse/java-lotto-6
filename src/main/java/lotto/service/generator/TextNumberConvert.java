package lotto.service.generator;

import lotto.Lotto;
import lotto.service.errorchek.ErrorCheck;

public class TextNumberConvert {
    public static long MoneyConvert(String input) {
        return ErrorCheck.MoneyInput(input);
    }

    public static Lotto WinnerNumberConvert(String input) {
        return ErrorCheck.WinnerNumberInput(input);
    }

    public static int BonusNumberConversion(String input) {
        return ErrorCheck.BonusNumberInput(input);
    }
}
