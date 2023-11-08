package lotto;

import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.view.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        Price price = lottoGame.bougthPrice();
        Lottos lottos = lottoGame.showLotto(price);
    }
}
