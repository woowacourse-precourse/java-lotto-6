package lotto.util.validator;

import static lotto.util.Separator.WINNING_NUMBERS_SEPARATOR;

import lotto.dto.WinningNumbersDto;

public class WinningNumbersDtoValidator implements Validator {
    public static final String WINNING_NUMBERS_IS_INVALID_FORMAT = "당첨 번호 형식에 맞게 입력해주세요. 예) 1,2,3,4,5,6";

    @Override
    public void validate(Object value) {
        validateSeperator((String) value);
    }

    private void validateSeperator(String winningNumbers) {
        validateRightSperator(winningNumbers);
        validateDoubleSeperator(winningNumbers);
        validateStartWord(winningNumbers);
        validateEndWord(winningNumbers);
    }

    private void validateRightSperator(String winningNumbers) {
        if (!winningNumbers.contains(WINNING_NUMBERS_SEPARATOR)){
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_INVALID_FORMAT);
        }
    }

    private void validateDoubleSeperator(String winningNumbers) {
        if (containsDoubleSeperator(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_INVALID_FORMAT);
        }

    }

    private boolean containsDoubleSeperator(String winningNumbers) {
        String doubleSeperator = WINNING_NUMBERS_SEPARATOR.repeat(2);
        return winningNumbers.contains(doubleSeperator);
    }

    private void validateStartWord(String winningNumbers) {
        if (winningNumbers.startsWith(WINNING_NUMBERS_SEPARATOR)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_INVALID_FORMAT);
        }
    }

    private void validateEndWord(String winningNumbers) {
        if (winningNumbers.endsWith(WINNING_NUMBERS_SEPARATOR)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_INVALID_FORMAT);
        }
    }

    @Override
    public boolean support(Class<?> clazz) {
        return WinningNumbersDto.class.isAssignableFrom(clazz);
    }
}
