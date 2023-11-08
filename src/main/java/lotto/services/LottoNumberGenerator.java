package lotto.services;

import java.util.List;
import lotto.utils.NumberGenerator;

public class LottoNumberGenerator {
    private final NumberGenerator numberGenerator;

    public LottoNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> generateNumbers() {
        return numberGenerator.generate();
    }
}
