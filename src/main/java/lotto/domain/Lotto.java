package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorMessages;

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
    }

    private static boolean isRightNumbers(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != Set.of(numbers).size();
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
