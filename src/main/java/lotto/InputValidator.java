package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {

    public int checkMoneyValidate(String input) {
        int money = 0;
        try {
            money = isOnlyNumber(input);
            isDivisibleBy1000(money);
        } catch (IllegalArgumentException e) {
            money = 0;
            System.out.println(e.getMessage());
        }
        return money;
    }

    private int isOnlyNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
        return number;
    }

    private void isDivisibleBy1000(int input) {
        if ((input % 1000) != 0 || input <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

}
