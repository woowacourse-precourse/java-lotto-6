package lotto.controller;

import static lotto.view.OutputBuyLottoCount.printBuyLotto;
import static lotto.view.OutputLottoList.printLottoList;
import static lotto.view.OutputStatistics.printStatistics;

import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoGroup;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;
import lotto.domain.WinningLotto;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyAmountView;
import lotto.view.InputWinningNumbersView;

public class LottoController {
    public void start() {
        Money money = getLottoMoney();
        printBuyLotto(money);

        LottoGroup lottoGroup = getLottoGroup(money);
        printLottoList(lottoGroup);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult, winningLotto, lottoGroup);

        Rate rate = getRate(money, prizeResult);
        printStatistics(prizeResult, rate);
    }

    private Money getLottoMoney() {
        InputBuyAmountView inputBuyLottoView = new InputBuyAmountView();
        int money = inputBuyLottoView.getInputValue();
        return new Money(money);
    }

    private LottoGroup getLottoGroup(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new LottoGroup(lottoGenerator.generateLottoGroup(money.getNumberTickets()));
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumbersView inputWinningLottoView = new InputWinningNumbersView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumbers = inputWinningLottoView.getInputValue();
        Integer bonusNumber = inputBonusNumberView.getInputValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, LottoGroup lottoGroup) {
        prizeResult.calcPrizeResult(winningLotto, lottoGroup);
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }
}
