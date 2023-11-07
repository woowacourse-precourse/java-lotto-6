package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDispenser;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private Money inputLottoPurchaseMoney() {
        try {
            return new Money(InputView.inputLottoPurchaseMoney());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printExceptionMessage(illegalArgumentException);
            return inputLottoPurchaseMoney();
        }
    }

    private Lottos issueLottos(Money money) {
        return LottoDispenser.issueLottos(money);
    }

    private void printIssuedLottos(Lottos lottos) {
        OutputView.printIssuedLottosInformation(lottos);
    }

    private WinningLotto issueWinningLotto() {
        try {
            Lotto lotto = new Lotto(InputView.inputLottoWinningNumber());
            OutputView.printNewEmptyLine();
            LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printExceptionMessage(illegalArgumentException);
            return issueWinningLotto();
        }
    }

    private WinningStatistics produceStatistics(WinningLotto winningLotto, Lottos issuedLottos) {
        return new WinningStatistics(winningLotto, issuedLottos);
    }

    private void printWinningStatistics(WinningStatistics winningStatistics) {
        OutputView.printWinningStatistics(winningStatistics);
    }
}
