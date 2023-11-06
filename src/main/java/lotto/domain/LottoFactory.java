package lotto.domain;

import java.util.List;

public class LottoFactory {

    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto create() {
        List<Integer> generatedNumbers = numberGenerator.generate(
                Lotto.LOTTO_NUMBER_MIN,
                Lotto.LOTTO_NUMBER_MAX,
                Lotto.LOTTO_NUMBER_SIZE
        );

        return new Lotto(generatedNumbers);
    }
}
