package lotto.domain;

import java.util.*;

public class Lotto {
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
        } else if (!isInRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean isSixNumbers(final List<Integer> numbers) {
        return numbers.size() == LottoInfo.SIZE.getNumber();
    }

    private boolean isInRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (!isInRangeForEach(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInRangeForEach(final int number) {
        return (number >= LottoInfo.RANGE_BEGIN.getNumber()) && (number <= LottoInfo.RANGE_END.getNumber());
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

    public int countMatchingWith(final Lotto otherLotto) {
        int numberOfMatching = 0;

        for (int number : numbers) {
            if (otherLotto.contains(number)) {
                numberOfMatching += 1;
            }
        }
        return numberOfMatching;
    }

    public boolean containsBonusNumber(final BonusNumber number) {
        return numbers.contains(number.getNumber());
    }

    private boolean contains(final int number) {
        return numbers.contains(number);
    }
}
