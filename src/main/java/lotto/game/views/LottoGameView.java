package lotto.game.views;

import java.util.List;
import java.util.Map;
import lotto.collaboration.lottostore.dto.PlayerLotto;
import lotto.collaboration.lottostore.enums.Prize;

public class LottoGameView {

    public final LottoStoreView lottoStoreView;
    public final WinningLottoView winningLottoView;

    public LottoGameView(final LottoStoreView lottoStoreView, final WinningLottoView winningLottoView) {
        this.lottoStoreView = lottoStoreView;
        this.winningLottoView = winningLottoView;
    }

    public int askPurchaseAmount() {
        return lottoStoreView.askPurchaseAmount();
    }

    public void announcePurchaseLottos(final List<PlayerLotto> purchaseLottos) {
        lottoStoreView.announcePurchaseLottos(purchaseLottos);
    }

    public List<Integer> askWinningNumbers() {
        return winningLottoView.askWinningNumbers();
    }

    public int askBonusNumber() {
        return winningLottoView.askBonusNumber();
    }

    public void announceWinningStatistics(final int purchaseAmount, final Map<Prize, List<PlayerLotto>> prizeListMap) {
        winningLottoView.announceWinningStatistics(purchaseAmount, prizeListMap);
    }

}
