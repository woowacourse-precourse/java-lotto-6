package lotto.game;

import lotto.collaboration.lottos.Lottos;
import lotto.io.lottos.LottosRandoms;
import lotto.io.views.LottoGameView;

public class LottoGame {

    private final LottoGameView lottoGameView;
    private final LottosRandoms lottosRandoms;

    public LottoGame(LottoGameView lottoGameView, LottosRandoms lottosRandoms) {
        this.lottoGameView = lottoGameView;
        this.lottosRandoms = lottosRandoms;
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
                System.out.println("[ERROR]" + e.getMessage());
            }
        }

        lottos.make(lottosRandoms);
    }

}
