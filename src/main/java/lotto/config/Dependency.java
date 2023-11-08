package lotto.config;

import lotto.app.collaboration.LottoStore;
import lotto.app.game.LottoGame;
import lotto.app.game.io.Input;
import lotto.app.game.io.Output;
import lotto.app.game.io.Randoms;
import lotto.app.game.views.LottoGameView;
import lotto.app.game.views.LottoStoreView;
import lotto.app.game.views.WinningLottoView;
import lotto.app.io.ConsoleInput;
import lotto.app.io.ConsoleOutput;
import lotto.app.io.game.LottosRandoms;

public final class Dependency {

    private static final Input INPUT = new ConsoleInput();
    private static final Output OUTPUT = new ConsoleOutput();
    private static final Randoms RANDOMS = new LottosRandoms();

    public static LottoGame lottoGame() {
        return new LottoGame(lottoGameView(), lottoStore(), randoms());
    }

    private static LottoGameView lottoGameView() {
        return new LottoGameView(lottoStoreView(), winningLottoView());
    }

    private static LottoStoreView lottoStoreView() {
        return new LottoStoreView(input(), output());
    }

    private static WinningLottoView winningLottoView() {
        return new WinningLottoView(input(), output());
    }

    private static LottoStore lottoStore() {
        return new LottoStore();
    }

    private static Randoms randoms() {
        return RANDOMS;
    }

    private static Input input() {
        return INPUT;
    }

    public static Output output() {
        return OUTPUT;
    }

}
