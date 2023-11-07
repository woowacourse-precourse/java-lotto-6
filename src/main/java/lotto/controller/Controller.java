package lotto.controller;

import lotto.service.Service;

public class Controller {
    private final Service service = new Service();

    public void run() {
        readyForGame();
    }

    private void readyForGame() {
        while (true) {
            try {
                service.purchaseLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void proceedGame() {

    }

    private void getResult() {

    }

}
