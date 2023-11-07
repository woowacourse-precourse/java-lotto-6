package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.lotto.LottoRepository;
import lotto.view.InputView;
import lotto.view.InputViewProxy;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(
                new InputViewProxy(new InputView()),
                new OutputView(),
                new LottoMachine(new LottoRepository())
        );
        lottoGame.startGame();
    }
}
