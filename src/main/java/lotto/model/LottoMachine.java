package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.util.generator.NumberGenerator;

public class LottoMachine {
    private final NumberGenerator<List<Integer>> numberGenerator;

    public LottoMachine(final NumberGenerator<List<Integer>> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLotto(final int count) {
        final List<Lotto> lottos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            final List<Integer> numbers = numberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return List.copyOf(lottos);
    }
}
