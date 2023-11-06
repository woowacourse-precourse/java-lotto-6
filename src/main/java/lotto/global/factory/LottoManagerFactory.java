package lotto.global.factory;

import lotto.module.domain.lotto.LottoNumberGenerator;
import lotto.module.domain.lotto.UserLottoTicketGenerator;
import lotto.module.manager.LottoManager;
import lotto.module.store.LottoStore;
import lotto.module.store.LottoTicketQuantityCalculator;

public class LottoManagerFactory {
    private static LottoManager lottoManager;
    private static LottoStore lottoStore;

    private static LottoTicketQuantityCalculator lottoTicketQuantityCalculator;
    private static LottoNumberGenerator lottoNumberGenerator;

    private LottoManagerFactory() {
    }

    public static LottoManager getSingletonLottoManager() {
        if (lottoManager == null) {
            lottoManager = LottoManager.of(LottoConsoleManagerFactory.getSingletonLottoConsoleManager(), getSingletonLottoStore());
        }
        return lottoManager;
    }

    private static LottoStore getSingletonLottoStore() {
        if (lottoStore == null) {
            lottoStore = LottoStore.of(getSingletonLottoTicketQuantityCalculator(), getSingletonLottoNumberGenerator());
        }
        return lottoStore;
    }

    private static LottoTicketQuantityCalculator getSingletonLottoTicketQuantityCalculator() {
        if (lottoTicketQuantityCalculator == null) {
            lottoTicketQuantityCalculator = LottoTicketQuantityCalculator.newInstance();
        }
        return lottoTicketQuantityCalculator;
    }

    private static LottoNumberGenerator getSingletonLottoNumberGenerator() {
        if (lottoNumberGenerator == null) {
            lottoNumberGenerator = UserLottoTicketGenerator.newInstance();
        }
        return lottoNumberGenerator;
    }

}
