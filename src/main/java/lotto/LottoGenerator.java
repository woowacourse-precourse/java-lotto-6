package lotto;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator() {
        lottos = new ArrayList<>();
    }
    public void generate(int amount) {
        Stream.iterate(0, i -> i + 1).limit(amount)
            .forEach(i -> lottos.add(Lotto.generate()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
