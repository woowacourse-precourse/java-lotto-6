package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final TypeChanger typeChanger = TypeChanger.getTypeChanger();

    public int money() {
        String input = Console.readLine();
        int money = typeChanger.from(input);
        isValidMoney(money);
        return money;
    }

    private void isValidMoney(int money) {
        ValidateMoney.isOverThousand(money);
        ValidateMoney.isUnitFollowed(money);
        ValidateMoney.isMoneyInRange(money);
    }
}
