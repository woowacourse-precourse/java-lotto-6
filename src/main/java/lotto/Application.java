package lotto;

import static lotto.app.enums.ApplicationMessage.EXCEPTION_APPLICATION;

import lotto.app.game.LottoGame;
import lotto.config.Dependency;

public class Application {

    public static void main(String[] args) {
        runWithExceptionHandle(() -> {
            LottoGame lottoGame = Dependency.lottoGame();
            lottoGame.run();
        });
    }

    private static void runWithExceptionHandle(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println(EXCEPTION_APPLICATION.get());
            throw e;
        }
    }

}
