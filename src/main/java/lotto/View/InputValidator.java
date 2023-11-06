package lotto.View;

import static lotto.Util.Constants.LOTTO_NUMBER_LENGTH;

import lotto.Util.ExceptionMessageFormatter;
import lotto.Util.LottoGameException;

public class InputValidator {
    private static final InputValidator INSTANCE = new InputValidator();
    private final String NUMBER_REGEX = "^[0-9]+$";
    private final String DELIMITER = ",";

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        return INSTANCE;
    }

    public void validateInputMoney(String inputMoney) {
        if (!isNumeric(inputMoney)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.NOT_A_NUMBER.getMessage()));
        }
    }

    public void validateInputWinningNumbers(String inputWinningNumbers) {
        if (!hasSixTokenWhenParseByDelimiter(inputWinningNumbers)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.WRONG_WINNING_NUMBER_FORMAT.getMessage()));
        }
        String[] numbers = inputWinningNumbers.split(DELIMITER);
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException(
                        ExceptionMessageFormatter.makeMessage(LottoGameException.NOT_A_NUMBER.getMessage()));
            }
        }
    }

    public void validateInputBonusNumber(String inputBonusNumber) {
        if (!isNumeric(inputBonusNumber)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.NOT_A_NUMBER.getMessage()));
        }
    }

    private boolean isNumeric(String input) {
        return input.matches(NUMBER_REGEX);
    }

    private boolean hasSixTokenWhenParseByDelimiter(String input) {
        String[] token = input.split(DELIMITER);
        return token.length == LOTTO_NUMBER_LENGTH;
    }

}
