package lotto.domain;
import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto{

    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }


}
