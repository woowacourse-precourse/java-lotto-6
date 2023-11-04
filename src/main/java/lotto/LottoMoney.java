package lotto;

import static lotto.message.LottoGameErrorMessage.BASE_UNIT_INPUT_MESSAGE;
import static lotto.message.LottoGameErrorMessage.NOT_ABLE_TO_PARSE_INT_MESSAGE;
import static lotto.message.LottoGameErrorMessage.UNDER_ZERO_MESSAGE;

import org.assertj.core.util.VisibleForTesting;

public class LottoMoney {
    private static final int BASE_MONEY_UNIT = 1000;
    private final int money;
    public LottoMoney(String input) {
        validate(input);
        money = Integer.parseInt(input);
    }

    public int getCountForBuyingLotto() {
        return money / BASE_MONEY_UNIT;
    }

    private void validate(String input) {
        if (!isAbleToParseInteger(input)) {
            throw new IllegalArgumentException(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage());
        }
        int number = Integer.parseInt(input);
        if (!isOverZero(number)) {
            throw new IllegalArgumentException(UNDER_ZERO_MESSAGE.getMessage());
        }
        if (!isBaseMoneyUnit(number)) {
            throw new IllegalArgumentException(BASE_UNIT_INPUT_MESSAGE.getMessage());
        }
    }

    @VisibleForTesting
    protected static boolean isAbleToParseInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @VisibleForTesting
    protected static boolean isOverZero(int number) {
        return number > 0;
    }

    @VisibleForTesting
    protected static boolean isBaseMoneyUnit(int number) {
        return number % BASE_MONEY_UNIT == 0;
    }

    public double calculateProfitPercentage(int totalWinMoney) {
        if (totalWinMoney == 0) {
            return 0;
        }
        String formattedProfit = String.format("%.2f", (double) totalWinMoney / money * 100);
        return Double.parseDouble(formattedProfit);
    }
}
