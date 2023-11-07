package lotto;

import controller.MainController;

public class Application {
    public static void main(String[] args) {
        try {
            MainController mainController = new MainController();
            mainController.start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}