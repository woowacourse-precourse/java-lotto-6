package lotto;

import java.util.List;
import lotto.Validator.LottoValidator;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
    }
}
