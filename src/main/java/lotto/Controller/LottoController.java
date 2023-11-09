package lotto.Controller;

import lotto.Model.*;
import lotto.Util.LottoGenerator;
import lotto.View.InputBonusNumberView;
import lotto.View.InputBuyLottoView;
import lotto.View.InputWinningNumberView;

import java.util.List;

import static lotto.View.OutputBuyLottoCount.printBuyLotto;
import static lotto.View.OutputLottoListView.printLottoList;
import static lotto.View.OutputResultView.printResult;

public class LottoController {

    public void run() {
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        WinningResult winningResult = new WinningResult();
        calcLottoResult(winningResult, winningLotto, lottos);

        Rate rate = getRate(money,winningResult);
        printResult(winningResult, rate);
    }

    private Money getLottoMoney() {
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.getValue();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getLotto()));
    }

    private WinningLotto getWinningLotto() {
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumbers = inputWinningNumberView.getValue();
        Integer bonusNumber = inputBonusNumberView.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(WinningResult winningResult, WinningLotto winningLotto, Lottos lottos) {
        winningResult.calcWinningResult(winningLotto, lottos);
    }

    private Rate getRate(Money money, WinningResult winningResult) {
        return new Rate(money, winningResult);
    }

}
