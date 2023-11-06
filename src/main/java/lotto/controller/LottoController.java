package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.util.Parser.stringToList;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Money money = askMoney();
        int count = money.getCount();
        List<Lotto> lottos = lottoGenerator.generateLottos(count);
        printBuyResult(lottos, count);
        WinningNumbers winningNumbers = makeWinningNumbers();
    }

    private Money askMoney() {
        Money money = new Money(inputView.requestMoney());
        outputView.printLottoCount(money.getCount());
        return money;
    }

    private void printBuyResult(List<Lotto> lottos, int count){
        outputView.printLottoCount(count);
        lottos.forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private WinningNumbers makeWinningNumbers() {
        Lotto lotto = new Lotto(inputView.requestWinningNumbers());
        int bonusNum = inputView.requestBonusNumber();
        return new WinningNumbers(lotto, bonusNum);
    }
}
