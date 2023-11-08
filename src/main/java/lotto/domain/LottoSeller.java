package lotto.domain;

import lotto.dto.Lottos;
import lotto.util.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Stream;

public class LottoSeller {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSeller(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos sellLottos(Cash cash) {
        Integer lottoCounts = cash.calculateNumberOfLottos();
        return createLottos(lottoCounts);
    }

    private Lottos createLottos(Integer lottoCounts) {
        List<Lotto> lottos = Stream.generate(this::generateLotto)
                .limit(lottoCounts)
                .toList();
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.generateLottoNumbers());
    }
}
