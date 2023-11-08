package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.constant.ExceptionMessages.*;
import static lotto.constant.SystemNumbers.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
        return new Lotto(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS.getNumber()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        long checkDuplication = numbers.stream().distinct().count();
        if (checkDuplication != numbers.size()) {
            throwDuplicateException();
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(Lotto::isNumberInRange)
                .forEach(number -> {throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        });
    }

    public static boolean isNumberInRange(Integer number) {
        return (number < MINIMUM_OF_NUMBER_RANGE.getNumber()) || (number > MAXIMUM_OF_NUMBER_RANGE.getNumber());
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containNumber)
                .count();
    }

    public static void throwDuplicateException() {
        throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
