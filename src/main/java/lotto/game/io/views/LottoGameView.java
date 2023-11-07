package lotto.game.io.views;

import java.util.List;
import java.util.Map;
import lotto.collaboration.enums.Prize;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.Input;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Output;

public class LottoGameView implements InteractionRepeatable {

    public final Input input;
    public final Output output;
    public final LottosView lottosView;
    public final WinningLottoView winningLottoView;

    public LottoGameView(Input input, Output output, LottosView lottosView, WinningLottoView winningLottoView) {
        this.input = input;
        this.output = output;
        this.lottosView = lottosView;
        this.winningLottoView = winningLottoView;
    }

    public int askPurchaseAmount() {
        return lottosView.askPurchaseAmount();
    }

    public void announcePurchaseLottos(List<PlayerLotto> purchaseLottos) {
        lottosView.announcePurchaseLottos(purchaseLottos);
    }

    public List<Integer> askWinningNumbers() {
        return winningLottoView.askWinningNumbers();
    }

    public int askBonusNumber() {
        return winningLottoView.askBonusNumber();
    }

    public void announceWinningStatistics(int purchaseAmount, Map<Prize, List<PlayerLotto>> prizeListMap) {
        winningLottoView.announceWinningStatistics(purchaseAmount, prizeListMap);
    }

}
