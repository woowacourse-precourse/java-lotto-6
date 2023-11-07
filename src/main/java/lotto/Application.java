package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.run();
        } catch (Exception exception) {
        }
    }
}
