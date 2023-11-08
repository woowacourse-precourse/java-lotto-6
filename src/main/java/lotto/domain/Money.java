package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Money {
    private static final int UNIT_PRICE = 1000;
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 금액을 입력했습니다.";
    private final int money;

    Money(int money) {
        validate(money);
        this.money = money;
    }

    public static Money createMoney() {
        try {
            return inputMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(INPUT_ERROR_MESSAGE);
            return createMoney();
        }
    }

    private static Money inputMoney() {
        OutputView.printMessage(MONEY_INPUT_MESSAGE);
        String input = InputView.readMessage();
        OutputView.printMessage();
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return new Money(money);
    }

    private void validate(int money) {
        if (money % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public int getMoney() {
        return money;
    }
}
