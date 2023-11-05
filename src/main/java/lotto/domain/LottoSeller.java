package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Stream;

public class LottoSeller {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSeller(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> sellLottos(Cash cash) {
        Integer lottoCounts = cash.calculateNumberOfLottos();
        return createLottos(lottoCounts);
    }

    private List<Lotto> createLottos(Integer lottoCounts) {
        return Stream.generate(this::generateLotto)
                .limit(lottoCounts)
                .toList();
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.generateLottoNumbers());
    }
}
