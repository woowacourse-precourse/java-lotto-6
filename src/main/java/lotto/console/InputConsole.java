package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Money;
import lotto.utils.StringToIntegerUtil;

public class InputConsole {
    public static Money getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();

        return StringToIntegerUtil.stringToMoney(input);
    }

}
