package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = askMoney();
        int count = money.getCount();
        Lottos lottos = buyLottos(count);
        printBuyResult(lottos, count);
        WinningNumbers winningNumbers = makeWinningNumbers();
    }

    private Money askMoney() {
        Money money = new Money(inputView.requestMoney());
        outputView.printLottoCount(money.getCount());
        return money;
    }

    private Lottos buyLottos(int count) {
        Lottos lottos = new Lottos();
        lottos.generateLottos(count);
        return lottos;
    }

    private void printBuyResult(Lottos lottos, int count){
        outputView.printLottoCount(count);
        lottos.getLottos().forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private WinningNumbers makeWinningNumbers() {
        Lotto lotto;
        try{
            lotto = new Lotto(inputView.requestWinningNumbers());
        }catch (IllegalArgumentException e) {
            lotto = new Lotto(inputView.requestWinningNumbers());
        }
        int bonusNum = inputView.requestBonusNumber();
        return new WinningNumbers(lotto, bonusNum);
    }
}
