package lotto;

import controller.Controller;
import service.Service;

public class Application {
    private static final Service service = new Service();
    private static final Controller controller = new Controller(service);
    public static void main(String[] args) {
        controller.run();
    }
}
