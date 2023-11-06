package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.NumberGenerator;

public class LottoService {
    private final NumberGenerator generator;

    public LottoService(NumberGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> generateWith(Money money) {
        return Stream.generate(()-> Lotto.from(generator.generate()))
            .limit(money.getLottoCount())
            .toList();
    }
}
