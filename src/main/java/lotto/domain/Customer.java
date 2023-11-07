package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

    private int money;

    public Customer() {
        int inputMoney = input();
        validateDigit(inputMoney);
        validateRange(inputMoney);
        this.money = inputMoney;
    }

    private int input() {
        String money = Console.readLine();
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }

        return Integer.parseInt(money);
    }

    private void validateDigit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위로 입력해주세요");
        }

    }

    private void validateRange(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요");
        }

    }

    public int getCount() {
        return money / 1000;
    }


}
