package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;


public class MoneyConverter {
    private final int chance;

    public MoneyConverter(String input) {
        patternCheck(input);
        this.chance = convertMoneyToChances(input);
    }

    private void patternCheck(String input) {
        if (!Constants.MONEY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_CONVERT_ERROR);
        }
    }

    private int convertMoneyToChances(String input) {
        return Integer.parseInt(input) / Constants.MONEY_UNIT;
    }

    public int getChance() {
        return chance;
    }
}
