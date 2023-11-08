package lotto;

import controller.LottoController;
import view.InputView;

public class Application {
    public static void main(String[] args) {

        LottoController ll = new LottoController();
        ll.startGame();
    }
}
