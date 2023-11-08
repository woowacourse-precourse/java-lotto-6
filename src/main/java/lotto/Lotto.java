package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    InputValidation iv = new InputValidation();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        iv.isWithinRange(numbers);
        iv.hasDuplicateNum(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }
}
