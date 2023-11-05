package lotto;

import lotto.utils.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.valid(numbers);
    }
    public boolean numberCheck(int number) {
        return numbers.contains(number);
    }
    public String getStringNumbers() {
        return numbers.toString();
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
