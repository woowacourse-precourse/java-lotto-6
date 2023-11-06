package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputWinningLottoView;

import java.util.List;

import static lotto.view.outputBuyLottoCount.printBuyLotto;
import static lotto.view.outputLottoList.printLottoList;
import static lotto.view.outputStatistics.printStatistics;
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
        try {
            InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
            int money = inputBuyLottoView.getValue();
            return new Money(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLottoMoney();
        }
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getTicket()));
    }

    private WinningLotto getWinningLotto() {
        try {
            InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
            InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

            List<Integer> winningNumbers = inputWinningLottoView.getValue();
            Integer bonusNumber = inputBonusNumberView.getValue();

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return getWinningLotto();
        }
    }

    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }
}
