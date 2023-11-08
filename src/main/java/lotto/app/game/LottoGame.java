package lotto.app.game;

import java.util.List;
import lotto.app.collaboration.LottoStore;
import lotto.app.collaboration.WinningLotto;
import lotto.app.collaboration.dto.PlayerLotto;
import lotto.app.game.io.InteractionRepeatable;
import lotto.app.game.io.Randoms;
import lotto.app.game.views.LottoGameView;

public class LottoGame implements InteractionRepeatable {

    private final LottoGameView lottoGameView;
    private final LottoStore lottoStore;
    private final Randoms randoms;

    public LottoGame(final LottoGameView lottoGameView, final LottoStore lottoStore, final Randoms randoms) {
        this.lottoGameView = lottoGameView;
        this.lottoStore = lottoStore;
        this.randoms = randoms;
    }

    public void run() {
        payOfPurchaseAmount();
        announceResult(receiveIssuedLottos(), askWinningLotto());
    }

    private void payOfPurchaseAmount() {
        runInteraction(() -> {
            int purchaseAmount = lottoGameView.askPurchaseAmount();
            lottoStore.purchase(purchaseAmount);
        });
    }

    private List<PlayerLotto> receiveIssuedLottos() {
        List<PlayerLotto> receivedLottos = lottoStore.issue(randoms);
        lottoGameView.announcePurchaseLottos(receivedLottos);
        return receivedLottos;
    }

    private WinningLotto askWinningLotto() {
        return supplyInteraction(() ->
                new WinningLotto(
                        lottoGameView.askWinningNumbers(),
                        lottoGameView.askBonusNumber()));
    }

    private void announceResult(List<PlayerLotto> receivedLottos, WinningLotto winningLotto) {
        lottoGameView.announceWinningStatistics(
                lottoStore.getPurchaseAmount(),
                winningLotto.matchNumbers(receivedLottos));
    }

}
