package lotto;

import lotto.controller.GameController;
import lotto.model.LottoDatas;

public class Application {
    public static void main(String[] args) {
        LottoDatas lotto = new LottoDatas();
        GameController controller = new GameController();
        controller.run();
    }
}
