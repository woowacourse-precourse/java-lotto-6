package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int payment;

    public void inputPayment(String input) {
        checkIntegerPayment(input);
        checkRemainderPayment();
        checkRangePayment();
    }

    public void checkIntegerPayment(String input) {
        try {
            payment = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하셨습니다.");
        }
    }

    public void checkRemainderPayment() {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public void checkRangePayment() {
        if (payment <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상만 입력 가능 합니다.");
        }
    }

    public int getManyLottoTicket() {
        return payment / 1000;
    }
}