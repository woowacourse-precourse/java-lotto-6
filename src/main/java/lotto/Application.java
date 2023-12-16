package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        Controller controller = new Controller(applicationConfig.lottoService());
        controller.run();
    }
}
