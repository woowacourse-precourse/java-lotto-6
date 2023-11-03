package lotto.controller;

import lotto.domain.PurchasePrice;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {

    //주입 방법을 다시 생각해보기
    //생성자 주입, 필드로 지정해주기
    private final Output output;
    private final Input input;

    //정적 팩토리 메서드를 사용해야하나
    public Controller(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    public void run() {
        output.requestPurchasePrice();
        PurchasePrice purchasePrice = PurchasePrice.from(input.purchasePrice());
    }
}
