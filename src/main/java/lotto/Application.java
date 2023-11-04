package lotto;

import lotto.configuration.Configuration;

public final class Application {
    public static void main(final String[] args) {
        Configuration
                .createLottoController()
                .run();
    }
}
