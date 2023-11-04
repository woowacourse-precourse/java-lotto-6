package lotto.util.validators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Parser;
import lotto.util.exception.DuplicationNumberException;

/**
 * 당첨 번호 입력을 검증하는 검사기
 */
public class WinningNumbersValidator {

    public static void validateWinningNumber(String winningNumbers) {
        validateNull(winningNumbers);
        validateEmpty(winningNumbers);
        List<String> parseWinningNumbers = Parser.parseString(winningNumbers);
        numberDuplicates(parseWinningNumbers);
    }

    private static void numberDuplicates(List<String> numbers) {
        Set<String> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw DuplicationNumberException.DUPLICATE_NUMBERS.getException();
        }
    }

    private static void validateNull(final String winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEmpty(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
