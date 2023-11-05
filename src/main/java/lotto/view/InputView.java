package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final int TICKET_PRICE = 1000;
    public static final String INPUT_LOTTO_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ERROR_LOTTO_BUDGET_RANGE = "[ERROR] 구입금액은 0원 이상 MAX 이하여야 합니다";
    public static final String ERROR_LOTTO_BUDGET_PRICE = "[ERROR] 구입금액은 1000원 단위여야 합니다. ";
    public static final String ERROR_LOTTO_BUDGET_INTEGER = "[ERROR] 구입음액은 숫자여야 합니다.";

    public int getLottoBudget() {
        System.out.println(INPUT_LOTTO_BUDGET_MESSAGE);
        int money = getIntegerMoney(Console.readLine());
        validateInputBudget(money);

        return money;
    }

    private void validateInputBudget(int money) {
        if (money <= 0 || 2_000_000_000 < money) {
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
