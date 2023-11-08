package lotto;

import lotto.controller.LottoController;
import lotto.domain.Statistic;
import lotto.service.LottoBroadCast;
import lotto.service.LottoChecker;
import lotto.service.StatisticProducer;
import lotto.service.Store;
import lotto.view.impl.BonusNumberView;
import lotto.view.impl.LottoBuyView;
import lotto.view.impl.StatisticView;
import lotto.view.impl.WinningNumberView;

public class Application {
    public static void main(String[] args) {
        Application.run();
    }

    private static void run() {
        LottoController lottoController = init();
        lottoController.operate();
    }

    private static LottoController init(){
        Store store = new Store(
                new LottoBuyView()
        );
        LottoBroadCast lottoBroadCast = new LottoBroadCast(
                new WinningNumberView(),
                new BonusNumberView()
        );

        StatisticView statisticView = new StatisticView();
        LottoChecker lottoChecker = new LottoChecker();

        StatisticProducer statisticProducer = new StatisticProducer(lottoChecker, new Statistic(), new StatisticView());
        return new LottoController(store, statisticProducer, statisticView, lottoBroadCast);
    }

}
