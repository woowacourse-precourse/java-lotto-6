package lotto;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1,000원 단위 숫자를 입력해주세요.");
            return inputMoney(); // 재귀적으로 다시 입력을 요청할 수도 있습니다.
        }
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();

    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            return inputBonusNumber();
        }
    }
}
