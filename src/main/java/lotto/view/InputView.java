package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

public class InputView {

    private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        String input = Console.readLine();
        checkBlank(input);
        return input;
    }

    private static void checkBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CHECK_BLANK.getMessage());
        }
    }
    public static String[] inputWinningNum() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        checkBlank(input);
        return input.split(",");
    }
    public static String inputBonusNum() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        checkBlank(input);
        return input;
    }
}
