package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public static Lotto create() {
        return new Lotto();
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    //computer's Lotto constructor
    private Lotto() {
        this.numbers = LottoMaker.generate();
    }

    //user's Lotto constructor
    private Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (isValidLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<Integer>(numbers).size();
    }
}
