package lotto;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    static String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void InputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        Console.readLine();
    }

    public void InputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        Console.readLine();
    }

    public void InputBounusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        Console.readLine();
    }
}
