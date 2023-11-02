package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();
        System.out.println();
        return money;
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String winningNumbers =  Console.readLine();
        System.out.println();
        return winningNumbers;
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}
