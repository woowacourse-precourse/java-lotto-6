package lotto.domain;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBERS;
import static lotto.exception.ErrorMessage.INVALID_RANGE;
import static lotto.exception.ErrorMessage.IS_NOT_SIX_NUMBERS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumber(String input){
        List<Integer> inputWinningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(inputWinningNumbers);
        return new WinningNumbers(inputWinningNumbers);
    }
    public static void validateLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw LottoException.of(IS_NOT_SIX_NUMBERS);
        }
    }
    public static void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw LottoException.of(DUPLICATE_NUMBERS);
        }
    }
    public static void validateRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw LottoException.of(INVALID_RANGE);
            }
        }
    }

}
