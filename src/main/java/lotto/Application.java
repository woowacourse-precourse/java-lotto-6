package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        try {
            Controller lottoController = new Controller();
            lottoController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
