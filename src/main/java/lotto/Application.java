package lotto;

import lotto.controller.LottoController;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        new LottoController().run();
    }
}
