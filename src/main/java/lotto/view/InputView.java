package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;

import java.util.List;

public class InputView {
    private static final String ASK_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getPaymentFromUserInput() {
        System.out.println(ASK_PAYMENT);
        return Parser.parsePay(Console.readLine());
    }

    public static List<Integer> getWinningNumbersFromUserInput() {
        System.out.println(ASK_WINNING_NUMBERS);
        return Parser.parseWinningNumber(Console.readLine());
    }

    public static int getBonusNumberFromUserInput() {
        System.out.println(ASK_BONUS_NUMBER);
        return Parser.parseBonusNumber(Console.readLine());
    }
}
