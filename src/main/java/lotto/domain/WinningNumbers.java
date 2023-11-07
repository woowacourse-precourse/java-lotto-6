package lotto.domain;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBERS;
import static lotto.exception.ErrorMessage.INVALID_RANGE;
import static lotto.exception.ErrorMessage.IS_NOT_ONE_NUMBER;
import static lotto.exception.ErrorMessage.IS_NOT_SIX_NUMBERS;
import static lotto.parser.Parser.parseWinningNumbers;
import static lotto.validator.InputValidator.validateEmpty;
import static lotto.validator.InputValidator.validateNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.LottoException;
import lotto.validator.InputValidator;

public class WinningNumbers {
    private static List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers(String input){
        InputValidator.validateEmpty(input);
        InputValidator.validateInputFormat(input);

        List<Integer> inputWinningNumbers = parseWinningNumbers(input);
        return new WinningNumbers(inputWinningNumbers);
    }
    private static void validateLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw LottoException.of(IS_NOT_SIX_NUMBERS);
        }
    }
    private static void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw LottoException.of(DUPLICATE_NUMBERS);
        }
    }
    private static void validateRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw LottoException.of(INVALID_RANGE);
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }



}
