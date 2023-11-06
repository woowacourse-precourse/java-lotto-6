package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String printLottoAmount(){
        printSpace();
        System.out.println(INPUT_AMOUNT);
        return Console.readLine();
    }

    public String printInputWinningNumber(){
        printSpace();
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String printInputBonusNumber(){
        printSpace();
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    private void printSpace(){
        System.out.println();
    }
}
