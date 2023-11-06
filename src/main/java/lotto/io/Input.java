package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Money setMoney() {
        return new Money(Console.readLine());
    }
}
