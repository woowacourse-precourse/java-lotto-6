package lotto;

import lotto.domain.Consumer;
import lotto.impl.GameShop;
import lotto.impl.LottoGame;
import lotto.impl.RandomNumberImpl;
import lotto.type.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.security.Principal;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameShop lottoGameShop = new GameShop(new LottoGame(new RandomNumberImpl()));

        Consumer consumer = new Consumer(lottoGameShop.purchase(InputView.readPurChaseLottoAmount()));
        OutputView.printPurchasedLotto(consumer.getPurchasedLotto());

        lottoGameShop.startLottoGame(InputView.readWinningNumber(), InputView.readBonusNumber());
        consumer.setPrizeResult(lottoGameShop.getResult(consumer.getPurchasedLotto()));

        OutputView.printLottoResults(consumer.getPrizeResult());
        OutputView.printReturnRate(consumer.getReturnRate());
    }
}
