package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Money;

public class InputReader {

    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public Money inputMoney() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return new Money(Console.readLine());
    }

}
