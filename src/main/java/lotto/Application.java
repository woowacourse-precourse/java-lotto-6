package lotto;

import lotto.domain.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = AppConfig.setup();
        controller.run();
    }
}
