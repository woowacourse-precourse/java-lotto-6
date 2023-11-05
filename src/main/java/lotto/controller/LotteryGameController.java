package lotto.controller;

import lotto.domain.lottery.LottoNumberGenerator;
import lotto.view.OutputView;
import lotto.view.InputView;

import static lotto.domain.constants.LottoConstraint.LOTTO_PRICE;

public class LotteryGameController {

    private final InputView inputView = new InputView();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private int lottoAmount;

    public void run() {
        OutputView.requestPurchaseAmountMessage();
        int purchaseAmount = amountOfLottos();

        purchaseLottos(purchaseAmount);
        OutputView.returnLottery(lottoAmount);

        OutputView.requestWinningNumberMessage();

        OutputView.requestBonusNumberMessage();

        OutputView.returnWinningStats();
    }


}
