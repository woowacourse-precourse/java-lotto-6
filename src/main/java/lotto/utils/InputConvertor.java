package lotto.utils;

import lotto.domain.Bonus;
import lotto.domain.Money;

public class InputConvertor {

    private static int convertStringtoInt(String input) {
        return Integer.parseInt(input);
    }

    public static Money convertMoney(String input) {
        return Money.from(convertStringtoInt(input));
    }

    public static Bonus convertBonus(String input) {
        return Bonus.from(convertStringtoInt(input));
    }

}
