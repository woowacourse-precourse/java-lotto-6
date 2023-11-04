package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int payment;

    public void inputPayment(String input) {
        checkInteger(input);
    }

    public void checkInteger(String input) {
        try {
            payment = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하셨습니다.");
        }
    }
}