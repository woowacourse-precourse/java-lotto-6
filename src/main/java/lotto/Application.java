package lotto;

import lotto.controller.LottoController;
import lotto.domain.Money;
import lotto.service.LottoBroadCast;
import lotto.service.StatisticProducer;
import lotto.service.Store;
import lotto.view.impl.BonusNumberView;
import lotto.view.impl.LottoBuyView;
import lotto.view.impl.StatisticView;
import lotto.view.impl.WinningNumberView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application.run();
    }


    private static void run() {
        Money lottoPrice = Money.wons(1000);

        Store store = new Store(
            new LottoBuyView()
        );
        LottoBroadCast lottoBroadCast = new LottoBroadCast(
                new WinningNumberView(),
                new BonusNumberView()
        );

        StatisticView statisticView = new StatisticView();


        StatisticProducer statisticProducer = new StatisticProducer();
        LottoController lottoController = new LottoController(store, statisticProducer, statisticView, lottoBroadCast);
        lottoController.operate();
    }
}
