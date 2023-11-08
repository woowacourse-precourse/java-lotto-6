package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.*;

public class LottoPlay {

    private Lotto Lotto;
    private BonusNumber BonusNumber;

    private LottoResult LottoResult;

    private LottoPurchase LottoPurchase;

    private CalculateProfit CalculateProfit;


    private OutputView OutputView;


    public void run() {

        userInput();
        LottoResult = new LottoResult(Lotto.getNumbers(), LottoPurchase.getRandomNumbers(), LottoPurchase.getLottoPurchaseCnt(),
            BonusNumber.getBonusNumber());

        CalculateProfit = new CalculateProfit(LottoPurchase.getLottoPurchaseCnt(), LottoResult.getLottoResult(), LottoResult.getBonusCheck());

        OutputView = new OutputView(LottoPurchase.getLottoPurchaseCnt(), LottoPurchase.getRandomNumbers(),LottoResult.getLottoResult(),CalculateProfit.getTotalProfit(), CalculateProfit.getRateOfReturn());
        OutputView.showRandomNumbers();
        OutputView.showLottoResult();
        OutputView.showRateOfReturn();

    }

    private void userInput() {
        InputView input = new InputView();
        LottoPurchase = new LottoPurchase(input.getLottoPurchase());
        Lotto = new Lotto(input.getLotto());
        BonusNumber = new BonusNumber(input.getBonusNumber());

    }
}
