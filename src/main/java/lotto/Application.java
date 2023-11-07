package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class Application {
    private static final AppConfig appConfig = new AppConfig();
    private static final LottoController lottoController = appConfig.lottoController();

    public static void main(String[] args) {
        lottoController.run();

        releaseResource();
    }

    private static void releaseResource() {
        Console.close();
    }
}
