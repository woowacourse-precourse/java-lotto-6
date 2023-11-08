package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;


public class MoneyConverter {
    private final int LottoBuyNum;

    public MoneyConverter(String userInput) {
        patternCheck(userInput);
        this.LottoBuyNum = convertMoneyToTickets(userInput);
    }

    private void patternCheck(String userInput) {
        if (!Constants.MONEY_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_CONVERT_ERROR);
        }
    }

    private int convertMoneyToTickets(String userInput) {
        return Integer.parseInt(userInput) / Constants.MONEY_UNIT;
    }

    public int getTickets() {
        return LottoBuyNum;
    }
}
