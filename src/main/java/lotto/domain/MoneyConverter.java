package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.regex.Pattern;

public class MoneyConverter {
    private final int chance;

    public MoneyConverter(String input) {
        patternCheck(input, Constants.MONEY_PATTERN);
        this.chance = convertMoneyToChances(input);
    }

    public void patternCheck(String input, Pattern pattern) {
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INFO
                            + ErrorMessage.MONEY_ERROR);
        }
    }

    public int convertMoneyToChances(String input) {
        return Integer.parseInt(input) / Constants.MONEY_UNIT;
    }

    public int getChance() {
        return chance;
    }
}
