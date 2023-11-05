package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.util.Conversion;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private Purchase purchase;
    private Lottos lottos;

    public void run() {
        payMoney();
        buyLottos();
    }

    private void payMoney() {
        try {
            int money = Conversion.stringToInt(InputView.purchase());
            purchase = new Purchase(money);
        } catch (IllegalArgumentException exception) {
            OutputView.error(exception.getMessage());
            payMoney();
        }
    }

    private void buyLottos() {
        List<Lotto> lotto = Lotto.generator(purchase.getCount());
        lottos = new Lottos(lotto);
    }
}
