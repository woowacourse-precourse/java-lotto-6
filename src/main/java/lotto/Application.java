package lotto;

import lotto.controller.SystemController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            SystemController systemController = SystemController.create();
            systemController.showResult();
        } catch (IllegalStateException e) {
            OutputView.exceptionMessage(e);
        }
    }
}
