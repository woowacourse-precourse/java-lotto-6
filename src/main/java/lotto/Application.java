package lotto;

import lotto.controller.LottoManager;

public class Application {
    public static LottoManager lottoManager;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoManager = new LottoManager();
        lottoManager.start();
    }
}
