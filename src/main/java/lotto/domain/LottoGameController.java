package lotto.domain;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.WinningLotto;
import lotto.global.utils.ExceptionHandlingUtil;
import lotto.global.view.InputView;
import lotto.global.view.OutputView;

public class LottoGameController {

    private final LottoStore lottoStore;

    public LottoGameController(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public void run() {
        Money money = generateMoney();
        OutputView.printPurchaseCount(money.getPurchaseLottoCount());

        List<Lotto> lottos = lottoStore.buyLotto(money);
        OutputView.printPurchaseLottos(lottos);

        GameResult gameResult = new GameResult(lottos, generateWinningLotto());
        OutputView.printWinningStats(gameResult, money);
    }


    private Money generateMoney() {
        return ExceptionHandlingUtil.handleException(() -> new Money(InputView.getPurchaseMoney()));
    }

    private WinningLotto generateWinningLotto() {
        Lotto winningNumbers = ExceptionHandlingUtil.handleException(this::generateLotto);
        return ExceptionHandlingUtil.handleException(
                () -> new WinningLotto(winningNumbers, InputView.getBonusNumber()));
    }

    private Lotto generateLotto() {
        return ExceptionHandlingUtil.handleException(() -> new Lotto(InputView.getWinningNumbersFromInput()));
    }
}
