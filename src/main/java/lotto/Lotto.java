package lotto;

import java.util.List;

import static lotto.ValidateService.*;

public class Lotto {
    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 45;
    static int NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateAuthorizedLength(numbers);
        validateDuplicatedNums(numbers);
        validateNumbersInRange(numbers);
    }
}
