package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputLottoWinningNumbersView;

import static lotto.view.OutputBuyLottoCount.printBuyLotto;
import static lotto.view.OutputStatistics.printStatistics;
import static lotto.view.OutputLottoList.printLottoList;

import java.util.List;

public class LottoController {

    public void start(){
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        LottoWinningNumber lottoWinningNumber = getLottoWinningNumber();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult,lottoWinningNumber,lottos);

        Rate rate = getRate(money, prizeResult);
        printStatistics(prizeResult, rate);
    }

    private Money getLottoMoney(){
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.insertCoin();
        return new Money(money);
    }

    private Lottos getLottos(Money money){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoList(money.getTicket()));
    }

    private LottoWinningNumber getLottoWinningNumber(){
        InputLottoWinningNumbersView inputLottoWinningNumbersView = new InputLottoWinningNumbersView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> lottoWinningNumbers = inputLottoWinningNumbersView.inputLottoWinningNumbers();
        Integer bonusNumber = inputBonusNumberView.inputBonusNumber();

        return new LottoWinningNumber(lottoWinningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, LottoWinningNumber lottoWinningNumber, Lottos lottos){
        prizeResult.calcPrizeResult(lottoWinningNumber, lottos);
    }

    private Rate getRate(Money money, PrizeResult prizeResult){
        return new Rate(money, prizeResult);
    }
}
