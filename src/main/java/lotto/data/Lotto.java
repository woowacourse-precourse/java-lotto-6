package lotto.data;

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
            throw new IllegalArgumentException(LottoUtil.ERROR_MESSAGE_PREFIX + LottoUtil.LOTTO_SIZE);
        }

        if (numbers.stream().distinct().toList().size() != numbers.size()) {
            throw new IllegalArgumentException(LottoUtil.ERROR_MESSAGE_PREFIX + LottoUtil.LOTTO_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
