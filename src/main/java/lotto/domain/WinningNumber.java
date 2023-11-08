package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constants.ExceptionMessage;
import lotto.constants.GameRule;
import lotto.utils.LottoGameException;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String numbers) {
        List<Integer> splitNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateSize(splitNumbers);
        validateDuplicate(splitNumbers);
        this.numbers = splitNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameRule.LOTTO_LENGTH) {
            throw LottoGameException.withMessage(ExceptionMessage.LOTTO_LENGTH_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>();
        numbers.stream()
                .filter(number -> !unique.add(number))
                .findAny()
                .ifPresent(duplicate -> {
                    throw LottoGameException.withMessage(ExceptionMessage.LOTTO_DUPLICATE_ERROR);
                });
    }

    public static WinningNumber consistOf(String numbers) {
        return new WinningNumber(numbers);
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }
}
