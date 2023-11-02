package lotto;

import lotto.domain.Consumer;
import lotto.impl.LottoGame;
import lotto.impl.RandomNumberImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGame lottoGame = new LottoGame(new RandomNumberImpl());

        Consumer consumer = new Consumer(lottoGame.purchase(InputView.readPurChaseLottoAmount()));
        OutputView.printPurchasedLotto(consumer.getPurchasedLotto());

        lottoGame.start(InputView.readWinningNumber(), InputView.readBonusNumber());




    }
}
