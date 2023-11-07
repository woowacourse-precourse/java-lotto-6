package lotto.controller;

import static lotto.view.OutputLottosView.printLottos;
import static lotto.view.OutputResultView.printResult;
import static lotto.view.OutputView.printBuyLotto;

import java.util.List;
import lotto.domain.*;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputWinningLottoView;

public class MainController {
    public void start() {
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult, winningLotto, lottos);
        Rate rate = getRate(money, prizeResult);
        printResult(prizeResult, rate);
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
