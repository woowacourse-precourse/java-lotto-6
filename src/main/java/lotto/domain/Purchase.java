package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private static int money;
    private int trials;
    private final String PURCHASE_INPUT_TEXT = "구입금액을 입력해 주세요.";
    private final String PURCHASE_DONE_TEXT = "개를 구매했습니다.";
    private final String ERROR_NOT_INTEGER_TEXT = "[ERROR] 숫자를 입력해주세요.";
    private final String ERROR_NOT_1k_TEXT = "[ERROR] 1,000원 단위로 입력해주세요.";

    public int purchasing() {
        while (true) {
            try {
                System.out.println(PURCHASE_INPUT_TEXT);
                money = readNumber();
                validate1k();
                this.trials = money / 1_000;
                System.out.println(purchaseDone());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return this.trials;
    }

    public static int getMoney() {
        return money;
    }

    private int readNumber() {
        try {
            String money = Console.readLine();
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_TEXT);
        }
    }

    private void validate1k() {
        if (money % 1_000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_1k_TEXT);
        }
    }

    private String purchaseDone() {
        return String.format("%,d%s", this.trials, PURCHASE_DONE_TEXT);
    }
}
