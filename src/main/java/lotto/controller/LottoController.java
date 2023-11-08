package lotto.controller;

import static lotto.view.Output.OutputBuyLottoCountView.printBuyLotto;
import static lotto.view.Output.OutputLottoListView.printLottoList;
import static lotto.view.Output.OutputStatisticsView.printStatistics;

import lotto.exception.EnterLottoMoneyFormatException;
import lotto.exception.EnterLottoMoneyZeroException;
import lotto.view.Input.InputBonusNumberView;
import lotto.view.Input.InputBuyLottoView;
import lotto.view.Input.InputWinningLottoView;

import java.util.List;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.RateOfReturn;
import lotto.domain.WinningLotto;
import lotto.domain.generator.LottoGenerator;

public class LottoController {

  public void run() {
    Money money = getLottoMoney();
    printBuyLotto(money);

    LottoList lottoList = getLottoList(money);
    printLottoList(lottoList);

    WinningLotto winningLotto = getWinningLotto();
    PrizeResult prizeResult = new PrizeResult();
    calcLottoResult(prizeResult, winningLotto, lottoList);

    RateOfReturn rateOfReturn = getRate(money, prizeResult);
    printStatistics(prizeResult, rateOfReturn);
  }

  private Money getLottoMoney() {
    InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
    try {
      int money = inputBuyLottoView.getValue();
      return new Money(money);
    } catch (EnterLottoMoneyFormatException | EnterLottoMoneyZeroException e) {
      System.out.println(e.getMessage());
      return getLottoMoney();
    }
  }

  private LottoList getLottoList(Money money) {
    LottoGenerator lottoGenerator = new LottoGenerator();
    return new LottoList(lottoGenerator.generateLottoGroup(money.getTicket()));
  }

  private WinningLotto getWinningLotto() {
    InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
    InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

    List<Integer> winningNumbers = inputWinningLottoView.getValue();
    Integer bonusNumber = inputBonusNumberView.getValue();

    return new WinningLotto(winningNumbers, bonusNumber);
  }

  private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, LottoList lottoList) {
    prizeResult.calcPrizeResult(winningLotto, lottoList);
  }

  private RateOfReturn getRate(Money money, PrizeResult prizeResult) {
    return new RateOfReturn(money, prizeResult);
  }
}