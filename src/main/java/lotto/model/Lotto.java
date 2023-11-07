package lotto.model;

import static lotto.InputValidator.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String numbers) {
        this.numbers = lottoValidator(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
