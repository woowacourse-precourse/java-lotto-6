package lotto.domain.lotto.opened;

import java.util.List;
import lotto.domain.lotto.boxed.LottoNumber;

public final class LottoOpened {

    private final List<LottoNumber> numbers;

    public LottoOpened(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
