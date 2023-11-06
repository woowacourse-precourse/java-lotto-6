package lotto.model;

import lotto.utils.Constants;
import lotto.utils.message.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
        validateLottoRange(numbers);
        return new Lotto(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_SIZE.getMessage());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        long numberCount = numbers.stream().distinct().count();
        if (numberCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchedNumber(Lotto winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::hasNumber)
                .count();
    }
}
