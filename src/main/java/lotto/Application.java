package lotto;

import controller.Controller;
import service.Service;

public class Application {
    private static Controller controller = new Controller(new Service());
    public static void main(String[] args) {
        controller.run();
    }
}
