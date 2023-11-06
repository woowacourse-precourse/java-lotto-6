package lotto.game;

import lotto.collaboration.lottos.Lottos;
import lotto.io.lottos.LottosRandoms;
import lotto.io.views.LottoGameView;

public class LottoGame {

    private final LottoGameView lottoGameView;

    public LottoGame(LottoGameView lottoGameView) {
        this.lottoGameView = lottoGameView;
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

        LottosRandoms lottoNumberAlgorithm = new LottosRandoms();
        lottos.make(lottoNumberAlgorithm);
    }

}
