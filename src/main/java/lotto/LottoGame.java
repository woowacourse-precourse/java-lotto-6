package lotto;

import lotto.models.LottoManager;
import lotto.models.LottoResult;
import lotto.models.WinningNumber;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoGame {

    private LottoManager lottoManager;

    public void start() {
        int money = InputView.inputPurchaseMoney();
        int lottoAmount = money / 1000;
        lottoManager = new LottoManager(lottoAmount);

        OutputView.printPurchaseLottos(lottoAmount, lottoManager.getLottos());

        WinningNumber winningNumber = InputView.inputWinningNumber();

        LottoResult lottoResult = lottoManager.calcLottoResult(winningNumber);
        OutputView.printLottoResult(lottoResult);
    }
}
