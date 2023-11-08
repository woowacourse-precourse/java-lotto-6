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
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final LottoGenerator lottoGenerator = new LottoGenerator(new SortedRandomNumberGenerator());
    private final ResultCalculator resultCalculator = new ResultCalculator();

    public void play() {
        Money money = getValidMoney();
        List<Lotto> lottos = lottoGenerator.generateForAmount(money);
        OutputView.printIssuedLotto(lottos);

        Lotto winningNumber = getValidWinningLotto();
        WinningLotto winningLotto = getValidBonusNumber(winningNumber);

        resultCalculator.calculateWinningCounts(lottos, winningLotto);
        resultCalculator.calculateProfitRate(money.getAmount());
        OutputView.printResult(resultCalculator);
    }

    private Money getValidMoney() {
        try {
            return new Money(InputView.getMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            return getValidMoney();
        }
    }

    private Lotto getValidWinningLotto() {
        try {
            return new Lotto(InputView.getWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            return getValidWinningLotto();
        }
    }

    private WinningLotto getValidBonusNumber(Lotto winningNumber) {
        try {
            return new WinningLotto(winningNumber, InputView.getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            return getValidBonusNumber(winningNumber);
        }
    }
}
