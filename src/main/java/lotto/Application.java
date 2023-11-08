package lotto;

import lotto.global.factory.LottoManagerFactory;
import lotto.module.manager.LottoManager;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = LottoManagerFactory.getSingletonLottoManager();
        lottoManager.run();
    }
}
