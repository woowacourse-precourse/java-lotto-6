package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_RANGE_BEGIN_NUMBER = 1;
    private static final int LOTTO_RANGE_END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_SIZE.getMessage());
        } else if (!isInLottoRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean isSixNumbers(final List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE;
    }

    private boolean isInLottoRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_RANGE_BEGIN_NUMBER || number > LOTTO_RANGE_END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicateNumbers(final List<Integer> numbers) {
        Set<Integer> numbersUnique = new HashSet<>(numbers);
        return numbersUnique.size() != numbers.size();
    }

    public static List<Integer> convertToIntegers(final String numbers) {
        List<String> numbersSplit = Arrays.asList(numbers.split(","));
        List<Integer> numbersConverted = new ArrayList<>();

        for (String number : numbersSplit) {
            try {
                numbersConverted.add(Integer.parseInt(number.strip()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_INTEGER.getMessage());
            }
        }
        return numbersConverted;
    }
}
