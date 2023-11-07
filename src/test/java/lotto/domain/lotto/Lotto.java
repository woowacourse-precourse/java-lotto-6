package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        LottoValidator.validateNumbers(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
