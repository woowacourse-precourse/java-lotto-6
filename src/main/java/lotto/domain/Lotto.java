package lotto.domain;

import java.util.List;
import lotto.validator.LottoNumberValidator;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.isValid(numbers);
        this.numbers = List.copyOf(numbers);
    }
}
