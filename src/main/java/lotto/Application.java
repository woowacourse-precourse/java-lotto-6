package lotto;

import lotto.controller.LottoController;
import lotto.domain.Money;
import lotto.domain.Store;
import lotto.service.StatisticProducer;
import lotto.validation.money.MoneyDivisionCondition;
import lotto.validation.money.MoneyValidation;
import lotto.validation.money.NumberCondition;
import lotto.view.impl.LottoBuyView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application.run();
    }


    private static void run() {
        Money lottoPrice = Money.wons(1000);
        Store store = new Store(
            new LottoBuyView(
                    new MoneyValidation(
                            new NumberCondition(), new MoneyDivisionCondition(lottoPrice)
                    )
            )
        );

        StatisticProducer statisticProducer = new StatisticProducer();

        LottoController lottoController = new LottoController(store, statisticProducer);
        lottoController.operate();
    }
}
