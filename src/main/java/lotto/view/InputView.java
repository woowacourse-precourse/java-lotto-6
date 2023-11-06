package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.utils.Parser.parseToInteger;
import static lotto.utils.Parser.parseToIntegers;

public class InputView {
    private static final String INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static Integer inputPurchaseAmount() {
        System.out.println(INPUT_BUY_MONEY_MESSAGE);
        String input = Console.readLine();
        //todo 구입 금액 검증
        return parseToInteger(input);
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        String input = Console.readLine();
        //todo 당첨 번호 검증 기능
        return parseToIntegers(input);
    }
}
