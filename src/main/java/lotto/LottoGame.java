package lotto;

import lotto.models.LottoManager;
import lotto.views.InputView;

import java.util.List;

public class LottoGame {

    public void start() {
        int money = InputView.inputPurchaseMoney();
        int lottoAmount = money / 1000;

        LottoManager lottoManager = new LottoManager(lottoAmount);

        List<Integer> winningNumbers = InputView.inputLottoWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();



    }

}
