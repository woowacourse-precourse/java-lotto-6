package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessages;
import lotto.enums.LottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (isRightNumbers(numbers)) {
            System.out.println(ErrorMessages.RIGHT_NUMBERS.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessages.RIGHT_NUMBERS.getErrorMessage());
        }
        if (isDuplicated(numbers)) {
            System.out.println(ErrorMessages.NOT_DUPLICATE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_DUPLICATE.getErrorMessage());
        }
        if (isNotInRange(numbers)) {
            System.out.println(ErrorMessages.IN_RANGE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessages.IN_RANGE.getErrorMessage());
        }
    }

    private static boolean isRightNumbers(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private boolean isNotInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoNumbers.MIN_RANGE.getNumber() || number > LottoNumbers.MAX_RANGE.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public int matchCount(Lotto other) {
        int count = 0;
        for (Integer otherNumber : other.getNumbers()) {
            if (contains(otherNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
