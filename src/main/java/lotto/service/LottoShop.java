package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoShop {
    private final LottoNumberGenerator lottoNumberGenerator;
    public LottoShop(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> sell(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> lottoNumberGenerator.generate())
                .map(Lotto::new)
                .toList();
    }
}
