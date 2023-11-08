package lotto;

import lotto.domain.controller.MainController;
import lotto.global.config.DependencyContainer;

public class Application {
    public static void main(String[] args) {
        DependencyContainer dependencyContainer = new DependencyContainer();
        MainController mainController = dependencyContainer.getMainController();
        mainController.startLotto();
    }
}
