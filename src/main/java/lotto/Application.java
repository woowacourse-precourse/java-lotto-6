package lotto;

import lotto.Controller.LottoGameController;
import lotto.View.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoGameController controller = new LottoGameController(view);
        controller.playLottoGame();
    }
}
