package lotto;

import lotto.config.Configuration;
import lotto.controller.Controller;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(Configuration.lottoFactory());

        controller.run();
    }
}
