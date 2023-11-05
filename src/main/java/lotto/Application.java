package lotto;

import controller.UserInput;
import model.Purchase;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    static void run(){
        Purchase purchase = new Purchase();

        purchase.Number(UserInput.purchasePrice());
        System.out.println(purchase.getPurchaseNumber());
    }



}
