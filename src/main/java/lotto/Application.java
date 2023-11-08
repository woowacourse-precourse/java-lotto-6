package lotto;

import lotto.adapter.view.LottoGameView;

public class Application {
    public static void main(String[] args) {
        LottoGameView lottoGameView = LottoFactory.createLottoGameView();
        lottoGameView.playGame();
    }
}
