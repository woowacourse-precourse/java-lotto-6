package lotto;

import java.util.List;
import lotto.view.Output;

public class Game {
    GameManager gameManager = new GameManager();

    public void startGame(){
        Output.printPurchaseAmountMessage();
        List<Lotto> totalLotto = gameManager.createLotto();
        Output.printPurchaseLottoQuantityMessage(totalLotto.size());
        Output.printTotalLotto(totalLotto);
    }
}
