package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.ResultCalculator;
import lotto.domain.WinningLotto;
import lotto.util.SortedRandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final LottoGenerator lottoGenerator = new LottoGenerator(new SortedRandomNumberGenerator());
    private final ResultCalculator resultCalculator = new ResultCalculator();

    public void play() {
        Money money = getValidMoney();
        List<Lotto> lottos = lottoGenerator.generateForAmount(money);
        OutputView.printIssuedLotto(lottos);

        WinningLotto winningLotto = getValidWinningLotto();
        getValidBonusNumber(winningLotto);

        resultCalculator.calculateWinningCounts(lottos, winningLotto);
        resultCalculator.calculateProfitRate(money.getAmount());
        OutputView.printResult(resultCalculator);
    }

    private Money getValidMoney() {
        try {
            return new Money(InputView.getMoney());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return getValidMoney();
        }
    }

    private WinningLotto getValidWinningLotto() {
        try {
            return new WinningLotto(InputView.getWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return getValidWinningLotto();
        }
    }

    private int getValidBonusNumber(WinningLotto winningLotto) {
        try {
            winningLotto.setBonusNumber(InputView.getBonusNumber());
            return winningLotto.getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return getValidBonusNumber(winningLotto);
        }
    }
}
