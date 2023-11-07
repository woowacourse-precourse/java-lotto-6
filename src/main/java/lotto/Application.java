package lotto;

import lotto.controller.LottoController;
import lotto.domain.Money;
import lotto.service.Store;
import lotto.service.StatisticProducer;
import lotto.view.impl.LottoBuyView;

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

        StatisticProducer statisticProducer = new StatisticProducer();

        LottoController lottoController = new LottoController(store, statisticProducer);
        lottoController.operate();
    }
}
