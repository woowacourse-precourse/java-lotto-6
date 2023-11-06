package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.Parser.parseToInteger;

public class InputView {
    private static final String INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static Integer inputPurchaseAmount() {
        System.out.println(INPUT_BUY_MONEY_MESSAGE);
        String input = Console.readLine();
        //todo 구입 금액 검증
        return parseToInteger(input);
    }
}
