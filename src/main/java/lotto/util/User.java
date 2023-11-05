package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int paymentAmount;

    public void inputPaymentAmount(String input) {
        checkInvalidPaymentAmount(input);
        checkUnitPaymentAmount();
        checkRangePaymentAmount();
    }

    public void checkInvalidPaymentAmount(String input) {
        try {
            paymentAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하셨습니다.");
        }
    }

    public void checkUnitPaymentAmount() {
        if (paymentAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public void checkRangePaymentAmount() {
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상만 입력 가능 합니다.");
        }
    }

    public int getManyLottoTicket() {
        return paymentAmount / 1000;
    }
}