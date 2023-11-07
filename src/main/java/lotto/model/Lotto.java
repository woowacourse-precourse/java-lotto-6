package lotto.model;

import lotto.service.ValidateSystem;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private ValidateSystem validateSystem = new ValidateSystem();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateSystem.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
