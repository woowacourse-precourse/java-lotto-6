package lotto.game;

import java.util.List;
import lotto.collaboration.lottos.Lottos;
import lotto.collaboration.lottos.WinningLotto;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Randoms;
import lotto.game.views.LottoGameView;

public class LottoGame implements InteractionRepeatable {

    private final LottoGameView lottoGameView;
    private final Randoms randoms;
    private final Lottos lottos;

    public LottoGame(final LottoGameView lottoGameView, final Randoms randoms, final Lottos lottos) {
        this.lottoGameView = lottoGameView;
        this.randoms = randoms;
        this.lottos = lottos;
    }

    public void run() {
        payOfPurchaseAmount();
        announceResult(receiveIssuedLottos(), getWinningLotto());
    }

    private void payOfPurchaseAmount() {
        runInteraction(() -> {
            int purchaseAmount = lottoGameView.askPurchaseAmount();
            lottos.purchase(purchaseAmount);
        });
    }

    private List<PlayerLotto> receiveIssuedLottos() {
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

    private void announceResult(List<PlayerLotto> buyLottos, WinningLotto winningLotto) {
        lottoGameView.announceWinningStatistics(
                lottos.getPurchaseAmount(),
                winningLotto.matchNumbers(buyLottos));
    }

}
