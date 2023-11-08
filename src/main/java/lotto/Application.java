package lotto;

import static lotto.app.enums.ApplicationMessage.EXCEPTION_APPLICATION;

import lotto.app.collaboration.LottoStore;
import lotto.app.game.LottoGame;
import lotto.app.game.views.LottoGameView;
import lotto.app.game.views.LottoStoreView;
import lotto.app.game.views.WinningLottoView;
import lotto.app.io.ConsoleInput;
import lotto.app.io.ConsoleOutput;
import lotto.app.io.game.LottosRandoms;

public class Application {

    public static void main(String[] args) {
        runWithExceptionHandle(() -> {
            LottoGame lottoGame = getLottoGame();
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

    private static LottoGame getLottoGame() {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();

        return new LottoGame(
                new LottoGameView(
                        new LottoStoreView(input, output),
                        new WinningLottoView(input, output)
                ),
                new LottoStore(),
                new LottosRandoms()
        );
    }

}
