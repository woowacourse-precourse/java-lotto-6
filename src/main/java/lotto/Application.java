package lotto;


import lotto.controller.lottoController;
import lotto.model.Cash;

public class Application {
    public static void main(String[] args) {
        lottoController controller = new lottoController();
        controller.run();
    }
}
