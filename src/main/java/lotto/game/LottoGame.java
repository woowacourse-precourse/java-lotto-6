package lotto.game;

import java.util.List;
import lotto.collaboration.lottos.Lotto;
import lotto.collaboration.lottos.Lottos;
import lotto.collaboration.lottos.WinningLotto;
import lotto.game.io.Randoms;
import lotto.game.io.views.LottoGameView;

public class LottoGame {

    private final LottoGameView lottoGameView;
    private final Randoms randoms;

    public LottoGame(LottoGameView lottoGameView, Randoms randoms) {
        this.lottoGameView = lottoGameView;
        this.randoms = randoms;
    }

    public void run() {
        Lottos lottos = new Lottos();
        // TODO : 리팩토링 필요
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = lottoGameView.askPurchaseAmount();
                lottos.purchase(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        List<Lotto> buyLottos = lottos.make(randoms);
        lottoGameView.announcePurchaseLottos(buyLottos);

        // TODO : winningNumbers와 bonusNumber는 아무리 봐도 하나의 타입이다.. 두 행동을 하나로 묶는 리팩토링을 수행하면 좋겠다.
        List<Integer> winningNumbers;
        int bonusNumber;
        // TODO : 위쪽 while-true문과 마찬가지로 리팩토링 필요
        WinningLotto winningLotto;
        while (true) {
            try {
                winningNumbers = lottoGameView.askWinningNumbers();
                bonusNumber = lottoGameView.askBonusNumber();
                winningLotto = new WinningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        lottoGameView.announceWinningStatistics(purchaseAmount,
                winningLotto.matchNumbers(buyLottos));
    }

}
