package lotto.game;

import java.util.List;
import lotto.collaboration.LottoStore;
import lotto.collaboration.WinningLotto;
import lotto.collaboration.dto.PlayerLotto;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Randoms;
import lotto.game.views.LottoGameView;

public class LottoGame implements InteractionRepeatable {

    private final LottoGameView lottoGameView;
    private final Randoms randoms;
    private final LottoStore lottoStore;

    public LottoGame(final LottoGameView lottoGameView, final Randoms randoms, final LottoStore lottoStore) {
        this.lottoGameView = lottoGameView;
        this.randoms = randoms;
        this.lottoStore = lottoStore;
    }

    public void run() {
        payOfPurchaseAmount();
        announceResult(receiveIssuedLottos(), getWinningLotto());
    }

    private void payOfPurchaseAmount() {
        runInteraction(() -> {
            int purchaseAmount = lottoGameView.askPurchaseAmount();
            lottoStore.purchase(purchaseAmount);
        });
    }

    private List<PlayerLotto> receiveIssuedLottos() {
        List<PlayerLotto> buyLottos = lottoStore.make(randoms);
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
                lottoStore.getPurchaseAmount(),
                winningLotto.matchNumbers(buyLottos));
    }

}
