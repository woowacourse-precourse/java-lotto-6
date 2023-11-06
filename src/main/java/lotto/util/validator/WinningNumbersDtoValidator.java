package lotto.util.validator;

import static lotto.util.Seperator.WINNING_NUMBERS_SEPARATOR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.WinningNumbersDto;

public class WinningNumbersDtoValidator implements Validator {
    @Override
    public void validate(Object value) {
        validateNull((String) value);
        validateSeperator((String) value);
    }

    private void validateNull(String winningNumbers) {
        if (winningNumbers.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private void validateSeperator(String winningNumbers) {
        validateRightSperator(winningNumbers);
        validateDoubleSeperator(winningNumbers);
        validateStartWord(winningNumbers);
        validateEndWord(winningNumbers);
    }

    private void validateRightSperator(String winningNumbers) {
        if (!winningNumbers.contains(WINNING_NUMBERS_SEPARATOR.getSeperator())){
            throw new IllegalArgumentException("당첨 번호 입력 형식에 맞지 않습니다.");
        }
    }

    private void validateDoubleSeperator(String winningNumbers) {
        if (containsDoubleSeperator(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호 입력 형식에 맞지 않습니다.");
        }

    }

    private boolean containsDoubleSeperator(String winningNumbers) {
        String doubleSeperator = WINNING_NUMBERS_SEPARATOR.getSeperator().repeat(2);
        return winningNumbers.contains(doubleSeperator);
    }

    private void validateStartWord(String winningNumbers) {
        if (winningNumbers.startsWith(WINNING_NUMBERS_SEPARATOR.getSeperator())) {
            throw new IllegalArgumentException("당첨 번호 입력 형식에 맞지 않습니다.");
        }
    }

    private void validateEndWord(String winningNumbers) {
        if (winningNumbers.endsWith(WINNING_NUMBERS_SEPARATOR.getSeperator())) {
            throw new IllegalArgumentException("당첨 번호 입력 형식에 맞지 않습니다.");
        }
    }

    @Override
    public boolean support(Class<?> clazz) {
        return WinningNumbersDto.class.isAssignableFrom(clazz);
    }
}
