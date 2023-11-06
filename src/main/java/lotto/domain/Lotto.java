package lotto.domain;

import java.util.*;

public class Lotto {
    private static final String WRONG_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개의 정수여야 합니다.";
    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "로또 번호는 정수여야 합니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 서로 다른 수여야 합니다.";
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
            throw new IllegalArgumentException(WRONG_SIZE_EXCEPTION_MESSAGE);
        } else if (!isInLottoRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        } else if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXCEPTION_MESSAGE);
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

    public static List<Integer> convertToIntegers(String numbers) {
        List<String> numbersSplit = Arrays.asList(numbers.split(","));
        List<Integer> numbersConverted = new ArrayList<>();

        for (String number : numbersSplit) {
            try {
                numbersConverted.add(Integer.parseInt(number.strip()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
            }
        }
        return numbersConverted;
    }
}
