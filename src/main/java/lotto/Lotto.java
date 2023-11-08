package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        InputValidator.validateLottoLength(numbers);
        InputValidator.validateNoDuplicates(numbers);

        for (int number: numbers) {
            InputValidator.validateIsLottoNumber(number);
        }
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }
}
