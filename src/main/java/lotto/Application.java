package lotto;

import lotto.configurer.AppConfigurer;
import lotto.controller.LottoGame;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();

        LottoGame lottoGame = new LottoGame(
                appConfigurer.outputView()
        );

        lottoGame.start();
    }
}
