package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.Result;
import lotto.Util.Validation;
import lotto.View.InputView;


public class LottoController {

    private static final int LOTTO_PRICE_PER_GAME = 1000;
    private int purchasedAmount = 0;

    private int calcAvailableAmount(int availableMoney) {
        return availableMoney / LOTTO_PRICE_PER_GAME;
    }

    private void purchaseLotto() {
        int availableMoney = InputView.getAvailableMoney();
        this.purchasedAmount = calcAvailableAmount(availableMoney);
    }
}
