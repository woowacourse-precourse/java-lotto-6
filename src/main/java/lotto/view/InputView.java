package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.\n";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.\n";

    public static String requestAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String requestWinningNumbers() {
        System.out.printf(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.printf(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}