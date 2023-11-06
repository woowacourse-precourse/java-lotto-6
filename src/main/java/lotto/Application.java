package lotto;

import lotto.controller.LottoController;
import lotto.controller.MoneyController;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class Application {
    public static void main(final String... args) {
        MoneyController moneyController = new MoneyController();
        LottoController lottoController = new LottoController();

        Money money = moneyController.inputMoney();
        Lottos lottos = lottoController.createLottos(money.calculateNumberOfLottoTickets());
        lottoController.printLottos(lottos);
    }
}
