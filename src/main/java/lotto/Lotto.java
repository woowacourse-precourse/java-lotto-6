package lotto;

import java.util.List;
import lotto.utils.LottoUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(LottoUtil::validateLottoNum);
    }

    // TODO: 추가 기능 구현
}
