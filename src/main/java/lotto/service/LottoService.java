package lotto.service;

import lotto.domain.Budget;
import lotto.domain.LottoSize;
import lotto.domain.Lottos;

public class LottoService {
    private volatile static LottoService INSTANCE;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (INSTANCE == null) {
            synchronized (LottoService.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LottoService();
        }
    }

    public Lottos createLottos(final Budget budget) {
        return Lottos.createLottos(budget);
    }

    public LottoSize getLottosSize(final Lottos lottos) {
        return new LottoSize(lottos.getLottosSize());
    }

    public String getLottosNumbers(final Lottos lottos) {
        return lottos.toString();
    }
}
