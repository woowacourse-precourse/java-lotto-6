package lotto.domain;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBERS;
import static lotto.exception.ErrorMessage.INVALID_DELIMITER;
import static lotto.parser.Parser.parseWinningNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateInputFormat(winningNumbers.toString());
        validateDuplicateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateInputFormat(String input) {
        if (!input.matches("\\d+(," + "\\d+)+")) {
            LottoException.of(INVALID_DELIMITER);
        }
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            LottoException.of(DUPLICATE_NUMBERS);
        }
    }

}
