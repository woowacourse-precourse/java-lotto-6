package lotto;

import lotto.model.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Payment payment = new Payment();

        int money = 0;
        int ticket = 0;

        while (true){
            try {
                money = inputView.getPaymentInput();
                payment.Payment(money);
                break;
            }catch (Exception e){
            }
        }
        ticket = payment.ticketNumber(money);
        outputView.printTicketNumber(ticket);
    }
}
