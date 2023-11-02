package lotto;

import lotto.domain.Consumer;
import lotto.impl.LottoGame;
import lotto.impl.RandomNumberImpl;
import lotto.type.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.security.Principal;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGame lottoGame = new LottoGame(new RandomNumberImpl());

        Consumer consumer = new Consumer(lottoGame.purchase(InputView.readPurChaseLottoAmount()));
        OutputView.printPurchasedLotto(consumer.getPurchasedLotto());

        lottoGame.start(InputView.readWinningNumber(), InputView.readBonusNumber());
        List<Prize> prizeList  = lottoGame.getResult(consumer.getPurchasedLotto());
        OutputView.printLottoResults(prizeList);
        System.out.println("총 수익률은 " + consumer.getReturnRate(prizeList) * 100 + "%입니다.");


    }
}
