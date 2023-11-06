package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public int inputAmount() {
        System.out.println(INPUT_AMOUNT);
        String amount = Console.readLine();
        return Integer.parseInt(amount);
    }

    public String inputWinningNumber() {
        System.out.println("\n"+INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        return winningNumber;
    }

}
