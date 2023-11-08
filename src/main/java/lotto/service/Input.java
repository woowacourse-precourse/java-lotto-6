package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static final String MESSAGE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_ENTER_WINNING_NUMBERS="당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_ENTER_BONUS_NUMBER="보너스 번호를 입력해 주세요.";

    public static String getPurchaseAmount() {
        System.out.println(MESSAGE_ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println();
        System.out.println(MESSAGE_ENTER_WINNING_NUMBERS);
        String input = Console.readLine();
        List<Integer> winningNumber = new ArrayList<>();
        for (String s : input.split(",")) {
            // 6개 맞는지
            // 숫자 맞는지
            winningNumber.add(Integer.parseInt(s));
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
            throw new IllegalArgumentException(e);
        }
    }
}
