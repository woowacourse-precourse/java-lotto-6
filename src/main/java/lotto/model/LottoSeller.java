package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {
    private final AutoLottoGenerator lottoGenerator;

    public LottoSeller(AutoLottoGenerator lottoGenerator) {
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
