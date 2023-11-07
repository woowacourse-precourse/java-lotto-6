package lotto.game;

import java.util.List;
import lotto.collaboration.lottos.Lottos;
import lotto.collaboration.lottos.WinningLotto;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Randoms;
import lotto.game.io.views.LottoGameView;

public class LottoGame implements InteractionRepeatable {

    private final LottoGameView lottoGameView;
    private final Randoms randoms;

    public LottoGame(LottoGameView lottoGameView, Randoms randoms) {
        this.lottoGameView = lottoGameView;
        this.randoms = randoms;
    }

    public void run() {
        Lottos lottos = new Lottos();

        payOfPurchaseAmount(lottos);
        List<PlayerLotto> buyLottos = receive(lottos);

        WinningLotto winningLotto = getWinningLotto();
        announceResult(lottos, buyLottos, winningLotto);
    }

    private void payOfPurchaseAmount(Lottos lottos) {
        runInteraction(() -> {
            int purchaseAmount = lottoGameView.askPurchaseAmount();
            lottos.purchase(purchaseAmount);
        });
    }

    private List<PlayerLotto> receive(Lottos lottos) {
        List<PlayerLotto> buyLottos = lottos.make(randoms);
        lottoGameView.announcePurchaseLottos(buyLottos);
        return buyLottos;
    }

    private WinningLotto getWinningLotto() {
        return supplyInteraction(() ->
                new WinningLotto(
                        lottoGameView.askWinningNumbers(),
                        lottoGameView.askBonusNumber()));
    }

    private void announceResult(Lottos lottos, List<PlayerLotto> buyLottos, WinningLotto winningLotto) {
        lottoGameView.announceWinningStatistics(
                lottos.getPurchaseAmount(),
                winningLotto.matchNumbers(buyLottos));
    }

}
