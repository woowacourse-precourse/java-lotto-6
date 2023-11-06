package lotto;

import lotto.controller.MainController;

public class Application {
    private static final String ERROR = "[ERROR] ";

    public static void main(String[] args) {
        try {
            MainController mainController = new MainController();
            mainController.start();
        } catch (Exception e) {
            System.out.println(ERROR + e.getMessage());
        }
    }
}
