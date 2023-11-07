package lotto.game;

import java.util.List;
import java.util.function.Supplier;
import lotto.collaboration.lottos.Lottos;
import lotto.collaboration.lottos.WinningLotto;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.Output;
import lotto.game.io.Randoms;
import lotto.game.io.views.LottoGameView;

public class LottoGame {

    public static final String ERROR_HEADER_MESSAGE = "[ERROR] ";
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
        runAnswer(() -> {
            int purchaseAmount = lottoGameView.askPurchaseAmount();
            lottos.purchase(purchaseAmount);
        });
    }

    private void runAnswer(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                output.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

    private <T> T supplyAnswer(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

    private List<PlayerLotto> receive(Lottos lottos) {
        List<PlayerLotto> buyLottos = lottos.make(randoms);
        lottoGameView.announcePurchaseLottos(buyLottos);
        return buyLottos;
    }

    private WinningLotto getWinningLotto() {
        return supplyAnswer(() ->
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
