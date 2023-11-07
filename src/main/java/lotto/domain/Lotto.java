package lotto.domain;

import java.util.List;
import lotto.validation.LottoValidator;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator validator = new LottoValidator();

        validator.validate(numbers);
    }
}
