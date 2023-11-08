package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoGenerator;
import lotto.view.BonusNumberReadView;
import lotto.view.ReadInputBuyView;
import lotto.view.ReadInputWinningLottoView;

import java.util.List;

import static lotto.view.outputBuyLottoNumberView.printLottoNumber;
import static lotto.view.outputLottosListView.printLottosList;
import static lotto.view.controllerOutputView.printStatistics;

public class Controller {

    public void start() {
        Money money = getLottoMoney();
        printLottoNumber(money);

        Lottos lottos = getLottos(money);
        printLottosList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult, winningLotto, lottos);

        Rate rate = getRate(money, prizeResult);
        printStatistics(prizeResult, rate);
    }

    private Money getLottoMoney() {
        ReadInputBuyView inputBuyLottoView = new ReadInputBuyView();
        int money = inputBuyLottoView.getValue();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getLottosNumber()));
    }

    private WinningLotto getWinningLotto() {
        ReadInputWinningLottoView inputWinningLottoView = new ReadInputWinningLottoView();
        BonusNumberReadView bonusNumberView = new BonusNumberReadView();

        List<Integer> winningNumbers = inputWinningLottoView.getValue();
        Integer bonusNumber = bonusNumberView.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }
}
