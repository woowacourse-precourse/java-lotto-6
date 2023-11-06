package lotto;

import lotto.controller.StartController;
import lotto.controller.ResultController;

public class Application {
    public static void main(String[] args) {
        StartController startController = new StartController();
        ResultController resultController = new ResultController();
        startController.startLotto();
        resultController.resultLotto();
    }
}
