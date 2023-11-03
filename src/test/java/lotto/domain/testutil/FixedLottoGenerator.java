package lotto.domain.testutil;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

public final class FixedLottoGenerator implements LottoGenerator {

    private final List<Integer> numbers;

    public FixedLottoGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generate() {
        return new Lotto(numbers);
    }
}
