package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.Constant;
import lotto.Domain.Money;

public class inputView {

    public Money inputMoney() {
        System.out.println(Constant.INPUT_PRICE_MESSAGE);
        return new Money(Console.readLine());
    }
}
