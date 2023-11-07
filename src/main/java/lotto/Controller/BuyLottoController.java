package lotto.Controller;

import lotto.Model.CountLotto;
import lotto.View.InputView.InputBuyLotto;

public class BuyLottoController {

    private final CountLotto countLotto;

    public BuyLottoController() {
        InputBuyLotto inputBuyLotto = new InputBuyLotto();
        int amountLotto = inputBuyLotto.getAmountLotto();

        countLotto = new CountLotto(amountLotto);
    }

    public int getCountLotto() {
        return countLotto.getCountLotto();
    }
}
