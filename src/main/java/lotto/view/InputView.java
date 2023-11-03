package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.money.Money;

public class InputView {

    public static Money getMoney() {
        return new Money(Console.readLine());
    }
}
