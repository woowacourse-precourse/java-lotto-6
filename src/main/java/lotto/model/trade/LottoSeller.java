package lotto.model.trade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public class LottoSeller {
    private final LottoGenerator lottoGenerator;

    public LottoSeller(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos sell(final int countOfLotto) {
        List<Lotto> lottos = IntStream.range(0, countOfLotto)
                .mapToObj(i -> generateAutoLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private Lotto generateAutoLotto() {
        return lottoGenerator.generate();
    }
}
