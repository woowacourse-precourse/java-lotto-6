package lotto.controller;

import lotto.domain.LotteryMessageBuilder;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoNumberGenerator;
import lotto.domain.lottery.Lottos;
import lotto.view.OutputView;
import lotto.view.InputView;

import static lotto.domain.constants.LottoConstraint.LOTTO_PRICE;

public class LotteryGameController {

    private final InputView inputView = new InputView();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final LotteryMessageBuilder lotteryMessageBuilder = new LotteryMessageBuilder();
    private final Lottos purchasedLotto = new Lottos();

    private int lottoAmount;

    public void run() {
        OutputView.requestPurchaseAmountMessage();
        int purchaseAmount = amountOfLottos();

        purchaseLotto(purchaseAmount);
        OutputView.returnLottery(lottoAmount,
                lotteryMessageBuilder.returnLottoList(purchasedLotto.getLottos()));

        OutputView.requestWinningNumberMessage();

        OutputView.requestBonusNumberMessage();

        OutputView.returnWinningStats();
    }

    private void purchaseLotto(int purchaseAmount) {
        lottoAmount = purchaseAmount / LOTTO_PRICE.getValue();

        for (int i = 0; i < lottoAmount; i++) {
            purchasedLotto.addLotto(new Lotto(lottoNumberGenerator.generateSortedLottoNumber()));
        }
    }
}
