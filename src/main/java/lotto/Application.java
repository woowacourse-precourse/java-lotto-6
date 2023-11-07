package lotto;

import lotto.config.ApplicationContainer;
import lotto.controller.LottoController;

public class Application {
    public static void main(final String[] args) {
        final ApplicationContainer container = new ApplicationContainer();
        final LottoController lottoController = container.getLottoController();
        lottoController.run();
    }
}
