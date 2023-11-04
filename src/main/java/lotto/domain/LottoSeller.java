package lotto.domain;

import static lotto.domain.Lotto.MAX_NUMBER;
import static lotto.domain.Lotto.MIN_NUMBER;
import static lotto.domain.Lotto.NUMBER_COUNT;

import java.util.List;

public class LottoSeller {

    private final NumberGenerator numberGenerator;

    public LottoSeller(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto buy() {
        final List<Integer> integers = numberGenerator.generate(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return new Lotto(integers);
    }
}
