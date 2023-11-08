package view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private static final String INPUT_LOTTO_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public InputView() {
    }

    public static String inputBuyLotto() {
        System.out.println(INPUT_LOTTO_BUY_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBER);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
        return convertToInt(Console.readLine());
    }

    public static int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            ExceptionView.OnlyNumberException();
        }
        return 0;
    }
}
