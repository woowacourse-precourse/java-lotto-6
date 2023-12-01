package lotto.service;

import lotto.domain.LottoBundle;
import lotto.domain.LottoGenerator;

public class LottoService {

    private static final LottoService instance = new LottoService();

    private final LottoGenerator lottoGenerator = LottoGenerator.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public LottoBundle createLottoBundle(int purchasePrice) {
        return lottoGenerator.generateLottoBundle(purchasePrice);
    }
}
