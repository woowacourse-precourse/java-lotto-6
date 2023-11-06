package lotto.controller;

import lotto.domain.Customer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView input;
    private final OutputView output;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        try {
            String money = input.inputMoney();
            Customer customer = new Customer(money);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            start();
        }
    }
}
