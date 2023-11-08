package lotto;

import lotto.models.LottoManager;
import lotto.models.LottoResult;
import lotto.models.WinNumber;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoGame {

    private LottoManager lottoManager;

    public void start() {
        int money = InputView.inputPurchaseMoney();
        int lottoAmount = calcLottoAmount(money);
        lottoManager = new LottoManager(lottoAmount);

        OutputView.printPurchaseLottos(lottoAmount, lottoManager.getLottos());

        WinNumber winNumber = InputView.inputWinNumber();

        LottoResult lottoResult = lottoManager.calcLottoResult(winNumber);
        OutputView.printLottoResult(lottoResult);
    }

    private int calcLottoAmount(int money) {
        return money / 1000;
    }
}
