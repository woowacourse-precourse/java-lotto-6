package lotto;

import lotto.model.Payment;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Payment payment = new Payment();

        while (true){
            try {
                int money = inputView.getPaymentInput();
                payment.Payment(money);
                break;
            }catch (Exception e){
            }
        }
    }
}
