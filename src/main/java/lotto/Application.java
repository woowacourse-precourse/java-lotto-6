package lotto;

import lotto.configurer.AppConfigurer;
import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();

        LottoGame lottoGame = new LottoGame(
                appConfigurer.inputView(),
                appConfigurer.outputView()
        );

        lottoGame.start();
    }
}
