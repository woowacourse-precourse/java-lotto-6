package lotto;

import configuration.Configuration;
import lotto.controller.LottoController;

public final class Application {
    public static void main(final String[] args) {
        final LottoController lottoController = Configuration
                .getInstance()
                .getLottoController();

        lottoController.run();
    }
}
