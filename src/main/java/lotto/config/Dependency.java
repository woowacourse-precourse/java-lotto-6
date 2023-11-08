package lotto.config;

import lotto.app.collaboration.LottoStore;
import lotto.app.game.LottoGame;
import lotto.app.game.views.LottoGameView;
import lotto.app.game.views.LottoStoreView;
import lotto.app.game.views.WinningLottoView;
import lotto.app.io.ConsoleInput;
import lotto.app.io.ConsoleOutput;
import lotto.app.io.game.LottosRandoms;

public final class Dependency {

    public static LottoGame lottoGame() {
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
