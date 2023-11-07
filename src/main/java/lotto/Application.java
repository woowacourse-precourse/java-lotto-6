package lotto;

import static lotto.enums.ApplicationMessage.EXCEPTION_APPLICATION;

import lotto.collaboration.LottoStore;
import lotto.game.LottoGame;
import lotto.game.views.LottoGameView;
import lotto.game.views.LottoStoreView;
import lotto.game.views.WinningLottoView;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;
import lotto.io.game.LottosRandoms;

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
                new LottosRandoms(),
                new LottoStore()
        );
    }

}
