package lotto;

import lotto.controllers.LottoStoreManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStoreManager view = new LottoStoreManager();
        view.purchaseController();
    }
}
