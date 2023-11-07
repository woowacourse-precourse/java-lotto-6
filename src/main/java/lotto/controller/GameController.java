package lotto.controller;

import lotto.Lotto;
import java.util.List;
import static lotto.controller.LottoController.*;

public class GameController {
    private List<Lotto> lotto;

    public GameController() {
        //구매 금액 입력
        setLotto();
    }

    private void setLotto() {
        int amount = setPurchaseAmount();
        lotto = setLottoNumber(amount);
    }
}
