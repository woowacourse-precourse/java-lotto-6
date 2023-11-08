package lotto.domain;

import lotto.constant.ExceptionType;
import lotto.constant.LottoConstant;
import lotto.util.TypeConverter;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = new ArrayList<>(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> numbersConverted;

        try {
            numbersConverted = TypeConverter.convertToIntegers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_WRONG_SIZE.getMessage());
        }

        validate(numbersConverted);
        numbersConverted.sort(Comparator.naturalOrder());
        this.numbers = numbersConverted;
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
        return numbers.size() == LottoConstant.SIZE.getNumber();
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
        return (number >= LottoConstant.RANGE_BEGIN.getNumber()) && (number <= LottoConstant.RANGE_END.getNumber());
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersUnique = new HashSet<>(numbers);
        return numbersUnique.size() != numbers.size();
    }

    public int countMatchingWith(Lotto otherLotto) {
        int matchingCounts = 0;

        for (int number : numbers) {
            if (otherLotto.contains(number)) {
                matchingCounts += 1;
            }
        }
        return matchingCounts;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
