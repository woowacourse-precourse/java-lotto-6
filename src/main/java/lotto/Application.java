package lotto;

import lotto.Controller.LottoController;
import lotto.View.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoView view = new LottoView();
        LottoController controller = new LottoController(view);

        controller.runGame();
    }
}
