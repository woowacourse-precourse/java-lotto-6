package domain;

import controller.Controller;

// 로또를 구입하는 대상에 관한 도메인
public class Buyer {
    Controller controller = new Controller();

    public int getPrice() {
        return controller.inputPriceControl();
    }
}