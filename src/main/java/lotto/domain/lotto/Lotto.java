package lotto.domain.lotto;

import java.util.List;

public class Lotto extends LottoRule {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
}
