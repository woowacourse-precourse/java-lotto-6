package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.PrizeCount;
import lotto.generator.LottosGenerator;
import lotto.domain.Money;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoFactory;
import lotto.dto.LottoResponse;
import lotto.generator.RandomLottosGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Money money = askMoney();
        Lottos playerLottos = generateLottos(money);
        printWinningResult(money, playerLottos);
    }

    private Money askMoney() {
        while (true) {
            try {
                return new Money(InputView.inputPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private Lottos generateLottos(Money money) {
        LottosGenerator lottosGenerator = new RandomLottosGenerator();
        Lottos lottos = lottosGenerator.generate(money);

        OutputView.printPurchasedCount(money.countPurchasedCount());
        OutputView.printPurchasedLottos(LottoResponse.of(lottos));

        return lottos;
    }

    private void printWinningResult(Money money, Lottos playerLottos) {
        WinningLotto winningLotto = askWinningLottoNumbers();
        askBonusNumber(winningLotto);

        PrizeCount prizeCount = new PrizeCount(playerLottos.match(winningLotto));

        OutputView.printPrizeCount(prizeCount);
        OutputView.printReturnRate(prizeCount.calculateReturnRate(money));
    }

    private WinningLotto askWinningLottoNumbers() {
        while (true) {
            try {
                return WinningLottoFactory.of(InputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void askBonusNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                winningLotto.setBonusNumber(new LottoNumber(InputView.inputBonusNumber()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
}