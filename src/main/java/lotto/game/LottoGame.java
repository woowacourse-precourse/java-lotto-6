package lotto.game;

import java.util.List;
import lotto.collaboration.lottos.Lottos;
import lotto.collaboration.lottos.WinningLotto;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.Output;
import lotto.game.io.Randoms;
import lotto.game.io.views.LottoGameView;

public class LottoGame {

    private final LottoGameView lottoGameView;
    private final Randoms randoms;
    private final Output output; // TODO : while-true 제거할 때 함께 제거할 것

    public LottoGame(LottoGameView lottoGameView, Randoms randoms, Output output) {
        this.lottoGameView = lottoGameView;
        this.randoms = randoms;
        this.output = output;
    }


    public void run() {
        Lottos lottos = new Lottos();

        payOfPurchaseAmount(lottos);
        List<PlayerLotto> buyLottos = receive(lottos);

        WinningLotto winningLotto = getWinningLotto();
        announceResult(lottos, buyLottos, winningLotto);
    }

    private void payOfPurchaseAmount(Lottos lottos) {
        // TODO : 리팩토링 필요
        while (true) {
            try {
                int purchaseAmount = lottoGameView.askPurchaseAmount();
                lottos.purchase(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                output.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private List<PlayerLotto> receive(Lottos lottos) {
        List<PlayerLotto> buyLottos = lottos.make(randoms);
        lottoGameView.announcePurchaseLottos(buyLottos);
        return buyLottos;
    }

    private WinningLotto getWinningLotto() {
        // TODO : winningNumbers와 bonusNumber는 아무리 봐도 하나의 타입이다.. 두 행동을 하나로 묶는 리팩토링을 수행하면 좋겠다.
        // TODO : 위쪽 while-true문과 마찬가지로 리팩토링 필요
        WinningLotto winningLotto;
        while (true) {
            try {
                List<Integer> winningNumbers = lottoGameView.askWinningNumbers();
                int bonusNumber = lottoGameView.askBonusNumber();
                winningLotto = new WinningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                output.println("[ERROR] " + e.getMessage());
            }
        }
        return winningLotto;
    }

    private void announceResult(Lottos lottos, List<PlayerLotto> buyLottos, WinningLotto winningLotto) {
        lottoGameView.announceWinningStatistics(
                lottos.getPurchaseAmount(),
                winningLotto.matchNumbers(buyLottos));
    }

}
