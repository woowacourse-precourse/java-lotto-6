package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private int amount;
    private String amountError = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public Input() {
        start();
    }

    private void start() {
        amount = Integer.parseInt(Console.readLine());
        amountValidate(amount);
    }

    private void amountValidate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(amountError);
        }

        makeLottoNumber(amount / 1000);
    }

    private void makeLottoNumber(int divisionAmount) {
        for (int i = 0; i < divisionAmount; i++) {

        }
    }
}
