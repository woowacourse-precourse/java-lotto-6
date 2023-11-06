package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.util.random.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Money money = readMoney();
        Lottos lottos = issueLottos(money);
        OutputView.printPurchasedLottos(lottos.tickets());

        WinningLotto winningLotto = readWinningLotto();

        LottoResult lottoResult = new LottoResult(winningLotto, lottos);
        printResultAndProfitRate(money, lottoResult);
    }

    private Money readMoney() {
        try {
            return new Money(InputView.readMoney());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readMoney();
        }
    }

    private static Lottos issueLottos(Money money) {
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        return lottoMachine.issue(money);
    }

    private WinningLotto readWinningLotto() {
        Lotto lotto = readLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        return createWinningLotto(lotto, bonusNumber);
    }

    private WinningLotto createWinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        try {
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createWinningLotto(lotto, readBonusNumber());
        }
    }

    private Lotto readLottoNumbers() {
        try {
            return new Lotto(InputView.readLottoNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readLottoNumbers();
        }
    }

    private LottoNumber readBonusNumber() {
        try {
            return new LottoNumber(InputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readBonusNumber();
        }
    }

    private static void printResultAndProfitRate(Money money, LottoResult lottoResult) {
        OutputView.printResults(lottoResult.getResults());

        double profitRate = money.getProfitRates(lottoResult.getTotalPrize());
        OutputView.printProfitRate(profitRate);
    }
}
