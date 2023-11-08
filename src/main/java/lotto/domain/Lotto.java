package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_WRONG_SIZE.getMessage());
        } else if (!isInRange(numbers)) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean isSixNumbers(List<Integer> numbers) {
        return numbers.size() == LottoConstants.SIZE.getNumber();
    }

    private boolean isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!isInRangeForEach(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInRangeForEach(int number) {
        return (number >= LottoConstants.RANGE_BEGIN.getNumber()) && (number <= LottoConstants.RANGE_END.getNumber());
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersUnique = new HashSet<>(numbers);
        return numbersUnique.size() != numbers.size();
    }

    public int countMatchingWith(Lotto otherLotto) {
        int numberOfMatching = 0;

        for (int number : numbers) {
            if (otherLotto.contains(number)) {
                numberOfMatching += 1;
            }
        }
        return numberOfMatching;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public static List<Integer> convertToIntegers(String numbers) {
        List<String> numbersSplit = Arrays.asList(numbers.split(","));
        List<Integer> numbersConverted = new ArrayList<>();

        for (String number : numbersSplit) {
            numbersConverted.add(convertToIntegersForEach(number));
        }
        return numbersConverted;
    }

    private static int convertToIntegersForEach(String number) {
        try {
            return Integer.parseInt(number.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_WRONG_SIZE.getMessage());
        }
    }
}
