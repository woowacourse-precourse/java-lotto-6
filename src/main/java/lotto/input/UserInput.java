package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validate;

public class UserInput {
    public static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해주세요";
    private final Validate validate = new Validate();
    private int money;

    public void askMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
        String inputMoney = Console.readLine();
        checkMoney(inputMoney);
    }

    public void checkMoney(String inputMoney) {
        validate.IsInteger(inputMoney);
        this.money = Integer.parseInt(inputMoney);
        validate.IsThousands(money);
    }

    public int getMoney() {
        return money;
    }
}