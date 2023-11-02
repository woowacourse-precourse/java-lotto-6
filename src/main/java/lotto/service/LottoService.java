package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

public class LottoService {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public Lotto generateLotto() {
        Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers());
        return lotto;
    }

}
