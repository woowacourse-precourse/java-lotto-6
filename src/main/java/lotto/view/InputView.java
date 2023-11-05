package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.Constants.*;

public class InputView {
    public static final String INPUT_LOTTO_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";

    public int getLottoBudget() {
        System.out.println(INPUT_LOTTO_BUDGET_MESSAGE);
        int money = getIntegerMoney(Console.readLine());
        validateInputBudget(money);

        return money;
    }

    private void validateInputBudget(int money) {
        if (money <= MIN_PRICE || MAX_PRICE < money) {
            throw new IllegalArgumentException(ERROR_LOTTO_BUDGET_RANGE);
        }

        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_LOTTO_BUDGET_PRICE);
        }
    }

    private int getIntegerMoney(String money) {
        try {
            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_LOTTO_BUDGET_INTEGER);
        }
    }
}
