package lotto;

import lotto.controller.StartController;

public class Application {
    public static void main(String[] args) {
        StartController startController = new StartController();
        startController.startLotto();
    }
}
