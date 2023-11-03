package lotto.controller;

import lotto.model.Customer;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.constant.ConstantMessage;
import static lotto.view.constant.ConstantMessage.PAY_MONEY;

public class LottoDraw {
    private Customer customer;

    public LottoDraw() {}
    public void start() {
        // 로또 구입 금액을 입력
        OutputView.printConstantMessage(PAY_MONEY);
        customer = new Customer(InputView.requestPayMoney());
        OutputView.printNewLine();
        OutputView.println(String.valueOf(customer.getMoney()));


        // 로또 발행

        // 당첨 번호 입력

        // 보너스 번호 입력

        // 당첨 통계
    }

    private void inputPayMoney() {

    }
}
