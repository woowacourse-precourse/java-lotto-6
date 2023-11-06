package lotto.Controller;

import static lotto.View.SystemMessage.GUESS_BUY_LOTTO;
import static lotto.View.SystemMessage.RESULT_BUY_LOTTO;

import lotto.Model.CountLotto;
import lotto.View.InputBuyLotto;

public class InputBuyLottoController {
    InputBuyLotto inputBuyLotto;
    CountLotto countLotto;

    public InputBuyLottoController() {
        inputControl();
    }

    private void inputControl() {
        System.out.println(GUESS_BUY_LOTTO.getMessage());
        inputBuyLotto = new InputBuyLotto();
        countLotto = new CountLotto(inputBuyLotto.getLotto());
        System.out.println(String.format(GUESS_BUY_LOTTO.getMessage(), countLotto.getCountLotto()));
    }
}
