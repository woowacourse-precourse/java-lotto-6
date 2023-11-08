package lotto.global.factory;

import lotto.module.lotto.LottoNumberGenerator;
import lotto.module.lotto.UserLottoTicketGenerator;
import lotto.module.store.LottoStore;
import lotto.module.store.LottoTicketQuantityCalculator;

public class LottoStoreFactory {
    private static LottoStore lottoStore;
    private static LottoNumberGenerator userLottoTicketGenerator;

    private static LottoTicketQuantityCalculator lottoTicketQuantityCalculator;

    private LottoStoreFactory() {
    }

    protected static LottoStore getSingletonLottoStore() {
        if (lottoStore == null) {
            lottoStore = LottoStore.of(getSingletonUserLottoTicketGenerator(), getSingletonLottoTicketQuantityCalculator());
        }
        return lottoStore;
    }

    private static LottoNumberGenerator getSingletonUserLottoTicketGenerator() {
        if (userLottoTicketGenerator == null) {
            userLottoTicketGenerator = UserLottoTicketGenerator.newInstance();
        }
        return userLottoTicketGenerator;
    }

    private static LottoTicketQuantityCalculator getSingletonLottoTicketQuantityCalculator() {
        if (lottoTicketQuantityCalculator == null) {
            lottoTicketQuantityCalculator = LottoTicketQuantityCalculator.newInstance();
        }
        return lottoTicketQuantityCalculator;
    }

}
