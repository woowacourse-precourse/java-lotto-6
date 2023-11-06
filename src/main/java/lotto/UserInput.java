package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {


    public int money() {
        String input = Console.readLine();
        int money = isNumber(input);
        isValidMoney(money);
        return money;
    }

    private int isNumber(String input) {
        ValidateNumber.isNumber(input);
        return Integer.parseInt(input);
    }

    private void isValidMoney(int money) {
        ValidateMoney.isOverThousand(money);
        ValidateMoney.isUnitFollowed(money);
        ValidateMoney.isMoneyInRange(money);
    }
}
