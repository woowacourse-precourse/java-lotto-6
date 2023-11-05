package lotto;

import lotto.controller.GameMainController;
import lotto.service.GameService;

public class Application {
    public static void main(String[] args) {
        try {
            GameMainController gameMainController = new GameMainController(new GameService());
            gameMainController.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
