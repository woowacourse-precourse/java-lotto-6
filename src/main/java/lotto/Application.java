package lotto;

import lotto.controller.LottoController;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController(new View());
        controller.run();
    }
}
