package lotto;

import lotto.models.LottoManager;
import lotto.models.WinningNumber;
import lotto.views.InputView;

import java.util.List;

public class LottoGame {

    private LottoManager lottoManager;

    public void start() {
        int money = InputView.inputPurchaseMoney();
        int lottoAmount = money / 1000;
        WinningNumber winningNumber = InputView.inputWinningNumber();

        lottoManager = new LottoManager(lottoAmount, winningNumber);


    }

}
