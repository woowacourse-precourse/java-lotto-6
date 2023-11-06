package lotto;

import lotto.models.LottoManager;
import lotto.models.WinningNumber;
import lotto.views.InputView;
import lotto.views.OutputView;

import java.util.List;

public class LottoGame {

    private LottoManager lottoManager;

    public void start() {
        int money = InputView.inputPurchaseMoney();
        int lottoAmount = money / 1000;
        lottoManager = new LottoManager(lottoAmount);

        OutputView.printPurchaseLottos(lottoAmount, lottoManager.getLottos());

        WinningNumber winningNumber = InputView.inputWinningNumber();

    }

}
