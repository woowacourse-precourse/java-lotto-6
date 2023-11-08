package lotto;

import lotto.controller.LottoController;
import lotto.domain.Store;

public class Application {
    public static void main(String[] args) {
        Store store = new Store();

        LottoController controller = new LottoController(store);
        controller.run();
    }
}
