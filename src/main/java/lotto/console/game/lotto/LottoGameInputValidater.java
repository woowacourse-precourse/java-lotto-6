package lotto.console.game.lotto;

import static lotto.console.game.lotto.constants.ExceptionMessages.*;
import static lotto.console.game.lotto.constants.GameConstants.*;

public class LottoGameInputValidater {
    public static void validateMoney(String moneyInput) throws IllegalArgumentException {
        validateParseInt(moneyInput);
        int money = LottoGameInputConverter.parseInt(moneyInput);

        if (money % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(makeErrorMessage(INVALID_NOT_MULTIPLE_THOUSAND, moneyInput));
        }
    }

    public static void validateNumbers(String numbersInput) throws IllegalArgumentException {
        if (!numbersInput.contains(","))
            throw new IllegalArgumentException(makeErrorMessage(INVALID_WRONG_SEPERATOR, numbersInput));

        String[] numberStrings = LottoGameInputConverter.splitStringByComma(numbersInput);

        if (numberStrings.length != 6)
            throw new IllegalArgumentException(makeErrorMessage(INVALID_WINNING_NUMBER_COUNT, numbersInput));

        for (String numberString : numberStrings)
            validateNumber(numberString);

    }

    public static void validateNumber(String numberInput) throws IllegalArgumentException {
        validateParseInt(numberInput);
        int number = LottoGameInputConverter.parseInt(numberInput);

        if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException(makeErrorMessage(INVALID_OUT_OF_RANGE_NUMBER, numberInput));
        }
    }

    public static void validateParseInt(String string) throws IllegalArgumentException {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(makeErrorMessage(INVALID_NOT_INTEGER, string));
        }
    }
}
