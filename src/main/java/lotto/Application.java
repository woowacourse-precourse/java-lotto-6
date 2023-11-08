package lotto;

import lotto.controller.LottoManager;

public class Application {
    public static LottoManager lottoManager;

    public static void main(String[] args) {
        lottoManager = new LottoManager();
        lottoManager.startLottoService();
    }
}
