package lotto.domain;

import lotto.enums.LottoNumbers;
import lotto.utils.StateChecker;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public static int getNumbersSize() {
        return NUMBERS_SIZE;
    }

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        for(int number : numbers) {
            if (!LottoNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int findCorrects(Lotto winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }
}
