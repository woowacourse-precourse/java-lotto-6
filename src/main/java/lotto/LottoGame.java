package lotto;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoService;
import lotto.lotto.WinningLotto;
import lotto.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final LottoService lottoService;

    public LottoGame(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        buyLottos(receiveMoney());
        WinningLotto winningLotto = receiveWinningLotto();
    }

    private void buyLottos(Money money) {
        List<Lotto> lottos = lottoService.makeLottos(money);
        OutputView.buyLottos(money, lottos);
    }

    private Money receiveMoney() {
        OutputView.inputMoney();
        return InputView.getMoney();
    }

    private WinningLotto receiveWinningLotto() {
        OutputView.inputWinningLotto();
        return InputView.getWinnerLotto();
    }
}
