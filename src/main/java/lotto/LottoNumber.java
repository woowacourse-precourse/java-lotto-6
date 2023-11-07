package lotto;

import java.util.List;
import lotto.exception.LottoNumberOutOfRangeException;

public record LottoNumber(int num) {
    public LottoNumber {
        if (num < 1 || num > 45) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    public boolean isMatched(final List<Integer> numbers) {
        return numbers.contains(num);
    }
}
