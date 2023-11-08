package lotto;

import static lotto.app.enums.ApplicationMessage.EXCEPTION_APPLICATION;

import lotto.app.game.LottoGame;
import lotto.config.Dependency;

public class Application {

    public static void main(String[] args) {
        try {
            LottoGame lottoGame = Dependency.lottoGame();
            lottoGame.run();
        } catch (Exception e) {
            System.out.println(EXCEPTION_APPLICATION.get());
            throw e;
        }
    }

}
