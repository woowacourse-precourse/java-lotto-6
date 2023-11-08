package lotto.service;

import lotto.controller.OrderController;
import lotto.domain.OrderCalculator;

import static lotto.values.ExceptionMessage.*;

public class OrderService {
    int lottoNumber;
    int money;

    public OrderService() {
        new OrderController(this);
    }

    public int generateLottoNumber(String input) {
        checkException(input);
        money = Integer.parseInt(input);
        return lottoNumber;
    }

    private void checkException(String input) {
        checkMoneyException(input);
        checkComputeException(input);
    }

    private void checkMoneyException(String input) {
        if (input.length() == 0) throw new IllegalArgumentException(NOT_NULL.getMessage());
        if (!input.matches(ONLY_NUMBER.getMessage())) throw new IllegalArgumentException(NOT_NUMBER.getMessage());
    }

    private void checkComputeException(String input) {
        OrderCalculator calculator = new OrderCalculator(input);
        if (!calculator.checkThousands()) throw new IllegalArgumentException(CAN_NOT_PURCHASE.getMessage());
        if (calculator.tooMuchValue()) throw new IllegalArgumentException(TOO_MUCH_MONEY.getMessage());

        lottoNumber = calculator.compute();
    }

    public int noticeLottoNumForDeliveryLotto() {
        return lottoNumber;
    }

    public int noticeMoneyForComputeEarning() {
        return money;
    }

}