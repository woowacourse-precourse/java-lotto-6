package lotto.global.factory;

import lotto.module.manager.LottoManager;

import static lotto.global.factory.LottoConsoleManagerFactory.getSingletonLottoConsoleManager;
import static lotto.global.factory.LottoResultManagerFactory.getSingletonLottoResultManager;
import static lotto.global.factory.LottoStoreFactory.getSingletonLottoStore;


public class LottoManagerFactory {
    private static LottoManager lottoManager;

    private LottoManagerFactory() {
    }

    public static LottoManager getSingletonLottoManager() {
        if (lottoManager == null) {
            lottoManager = LottoManager.of(getSingletonLottoConsoleManager(), getSingletonLottoResultManager(), getSingletonLottoStore());
        }
        return lottoManager;
    }

}
