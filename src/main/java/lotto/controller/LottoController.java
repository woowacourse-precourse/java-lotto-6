package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;
import lotto.domain.WinningLotto;
import lotto.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputWinningLottoView;

import java.util.List;

import static lotto.view.OutputBuyLottoCount.printBuyLotto;
import static lotto.view.OutputLottoList.printLottoList;
import static lotto.view.OutputStatistics.printStatistics;

public class LottoController {

    public void start() {
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult, winningLotto, lottos);

        Rate rate = getRate(money, prizeResult);
        printStatistics(prizeResult, rate);
    }

    private Money getLottoMoney() {
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.getValue();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getTicket()));
    }

    private WinningLotto getWinningLotto() {
        InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumbers = inputWinningLottoView.getValue();
        Integer bonusNumber = inputBonusNumberView.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }
}
