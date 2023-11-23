package lotto.domain.lotto;

import lotto.domain.lotto.generator.LottoGenerator;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto generateLotto() {
        return lottoGenerator.generate();
    }
}
