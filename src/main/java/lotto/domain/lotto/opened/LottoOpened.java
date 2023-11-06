package lotto.domain.lotto.opened;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.boxed.LottoNumber;

public final class LottoOpened extends Lotto {

    public LottoOpened(final List<Integer> numbers) {
        super(numbers);
    }

    public List<Integer> getNumbers() {
        return super.numbers
                .stream()
                .map(LottoNumber::getValue)
                .toList();
    }
}
