package lotto;

import lotto.controller.LottoController;

public class AppConfig {

    public static LottoController getLottoController() {
        return new LottoController();
    }

}
