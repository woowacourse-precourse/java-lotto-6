package lotto;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        Console.readLine();
    }

    public void inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        Console.readLine();
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        Console.readLine();
    }
}
