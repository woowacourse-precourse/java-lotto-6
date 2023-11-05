package lotto;

import lotto.controller.StateController;

public class Application {
    public static void main(String[] args) {
        StateController stateController = new StateController();
        stateController.run();
    }
}
