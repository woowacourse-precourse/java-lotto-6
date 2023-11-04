package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int payment;

    public void inputPayment(String input) {
        checkInteger(input);
        checkRemainder();
        checkRange();
    }

    public void checkInteger(String input) {
        try {
            payment = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하셨습니다.");
        }
    }

    public void checkRemainder() {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public void checkRange() {
        if (payment <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상만 입력 가능 합니다.");
        }
    }

    public int getLottoTicket() {
        return payment / 1000;
    }
}