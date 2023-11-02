package lotto;

import lotto.Controller.Controller;

public class Application {
    public static void main(String[] args) {
        try{
            Controller controller = new Controller();
            controller.LotteStart();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
