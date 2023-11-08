package lotto.lotto;

import java.util.List;
import lotto.config.LottoConfig;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SLOT_NUMBER.getNum()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
    // TODO: 추가 기능 구현
}
