package lotto;

import lotto.controller.MainController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            MainController mainController = new MainController();
            mainController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
