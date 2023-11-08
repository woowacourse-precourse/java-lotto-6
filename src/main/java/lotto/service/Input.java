package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static final String MESSAGE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getPurchaseAmount() {
        System.out.println(MESSAGE_ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println();
        System.out.println(MESSAGE_ENTER_WINNING_NUMBERS);
        String input = Console.readLine();
        List<Integer> winningNumber = new ArrayList<>();
        try {
            for (String s : input.split(",")) {
                winningNumber.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            Output.printErrorMessage(" 유효 숫자가 아닙니다.");
        }
        if (winningNumber.size() != 6) {
            Output.printErrorMessage(" 6개 숫자를 입력해주세요.");
            throw new IllegalArgumentException("6개 숫자를 입력해주세요.");
        }

        return winningNumber;
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println(MESSAGE_ENTER_BONUS_NUMBER);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Output.printErrorMessage(" 유효 숫자가 아닙니다.");
        }
        return 0;
    }
}
