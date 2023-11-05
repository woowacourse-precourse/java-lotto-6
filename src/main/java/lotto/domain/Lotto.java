package lotto.domain;

import lotto.enums.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE
                || numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        for (Integer number: numbers) {
            if (!LottoNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int getNumbersSize() {
        return NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int findCount(List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        return count;
    }
}
