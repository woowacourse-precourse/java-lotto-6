package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputService {
    public Money requestMoney() {
        String input = Console.readLine();
        return new Money(Integer.parseInt(input));
    }
}
