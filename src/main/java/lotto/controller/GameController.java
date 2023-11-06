package lotto.controller;

import lotto.domain.Customer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView input;
    private final OutputView output;
    private Customer customer;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        try {
            String money = input.inputMoney();
            customer = new Customer(money);
            resultBuyLotto();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            start();
        }
    }

    private void resultBuyLotto() {
        customer.buyNewLotto();
        int num = customer.calculateLottoNum();
        List<String> texts = customer.getLottoTexts();

        output.printLottoNumAndNumbers(num, texts);
    }
}
