package lotto;

import lotto.domain.Consumer;
import lotto.impl.GameShop;
import lotto.impl.LottoGame;
import lotto.impl.RandomNumberImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameShop lottoGameShop = new GameShop(new LottoGame(new RandomNumberImpl()));
        try {
            Consumer consumer = Consumer.purchaseLotto(lottoGameShop.purchase(InputView.readPurChaseLottoAmount()));
            OutputView.printPurchasedLotto(consumer.getPurchasedLotto());

            lottoGameShop.startLottoGame(InputView.readWinningLotto());
            consumer.setPrizeResult(lottoGameShop.getResults(consumer.getPurchasedLotto()));

            OutputView.printLottoResults(consumer.getPrizeResult());
            OutputView.printReturnRate(consumer.getReturnRate());
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

    }
}
