package lotto;

import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.LOTTO_NUMBER_LENGTH;
import static lotto.Constants.MessageConstant.COMMA;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {


    public static final int ONE = 1;
    public static final int INIT_NUM = 0;
    public static final char COMMA_CHARACTER = ',';
    private final List<LottoNumber> winningNumbers;

    private WinningNumber(String input) {
        isBlank(input);
        input = input.trim();
        validateCommaAtBothEndsForInput(input);
        String[] numbers = input.split(COMMA);
        validateNumbersCount(numbers);
        validateDuplicated(numbers);
        winningNumbers = Arrays.stream(numbers).map(LottoNumber::newInstance).toList();
    }

    public static WinningNumber newInstance(String input) {
        return new WinningNumber(input);
    }



    private void validateDuplicated(String[] numbers) {
        int count = (int) Arrays.stream(numbers).distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException(ERROR_NO_INPUT_DUPLICATED);
        }
    }

    private void validateCommaAtBothEndsForInput(String input) {
        if (startsWithComma(input) || endsWithComma(input)) {
            throw new IllegalArgumentException(ERROR_NO_INPUT_COMMA_IN_START_AND_END);
        }
    }

    private boolean startsWithComma(String input) {
        return input.charAt(INIT_NUM) == COMMA_CHARACTER;
    }

    private boolean endsWithComma(String input) {
        return input.charAt(input.length() - ONE) == COMMA_CHARACTER;
    }

    private void isBlank(String input) {
        if (input != null && !input.isBlank()) {
            return;
        }
        throw new IllegalArgumentException(ERROR_NO_INPUT_BLANK);
    }

    private void validateNumbersCount(String[] numbers) {
        if (numbers.length != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_INPUT_LOTTO_NUMBER_LENGTH);
        }
    }
}
