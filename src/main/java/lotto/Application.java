package lotto;

import lotto.controller.Service;

public class Application {
    public static void main(String[] args) {
        Service service = new Service();
        service.start();
    }
}
