package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validate;
import lotto.domain.Money;

public class UserInput {
    public static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해주세요";

    public Money askMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
        String inputMoney = Console.readLine();
        return new Money(inputMoney);
    }
}