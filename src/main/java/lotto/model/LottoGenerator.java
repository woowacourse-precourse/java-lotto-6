package lotto.model;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.constant.ErrorMessage.NOT_POSITIVE;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator() {
        lottos = new ArrayList<>();
    }
    public void generate(int amount) {
        try {
            Stream.iterate(0, i -> i + 1).limit(amount)
                .forEach(i -> lottos.add(Lotto.generate()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_POSITIVE.getMessage());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
