package lotto;

import lotto.manager.LottoManager;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        lottoManager.start();
    }
}
