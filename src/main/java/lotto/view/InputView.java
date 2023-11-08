package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputAmount() {
        print(INPUT_AMOUNT_MESSAGE);
        int num = Integer.parseInt(Console.readLine());
        return num;
    }

    public static int inputBonusNumber() {
        print(INPUT_BONUS_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static String inputWinningLottoNumber() {
        print(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    private static void print(String message) {
        System.out.print(message);
        NewLine();
    }

    private static void NewLine() {
        System.out.print("\n");
    }
}
