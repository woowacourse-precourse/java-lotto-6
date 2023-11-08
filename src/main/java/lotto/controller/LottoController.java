package lotto.controller;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

import static lotto.view.OutputLottoCountView.printLottoCount;
import static lotto.view.OutputLottosView.printLotto;
import static lotto.view.OutputLottoResult.printResult;

public class LottoController {

    public void play(){
        Price price = getLottoPrice();
        printLottoCount(price);

        Lottos lottos = getLottos(price);
        printLotto(lottos);

        WinningNumberLotto winningNumberLotto = getWinningNumberLotto();
        RankResult rankResult = new RankResult();
        countLottoResult(rankResult, winningNumberLotto, lottos);

        Rate rate = getRate(price, rankResult);
        printResult(rankResult, rate);

    }

    private Price getLottoPrice(){
        InputPurchaseAmountView inputPurchaseAmountView = new InputPurchaseAmountView();
        int purchaseAmount = inputPurchaseAmountView.inputAmountView();
        return new Price(purchaseAmount);
    }

    private Lottos getLottos(Price price) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.LottosGenerator(price.getPrice()));
    }

    private WinningNumberLotto getWinningNumberLotto(){
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> winningNumbers = inputWinningNumberView.inputWinningNumbers();
        int bonusNumber = inputBonusNumber.inputBonusNumber();

        return new WinningNumberLotto(winningNumbers, bonusNumber);
    }

    private void countLottoResult(RankResult rankResult, WinningNumberLotto winningNumberLotto, Lottos lottos){
        rankResult.countRankResult(winningNumberLotto, lottos);
    }

    private Rate getRate(Price price, RankResult rankResult){
        return new Rate(price, rankResult);
    }
}
