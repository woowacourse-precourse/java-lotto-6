package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputWinningNumberView {

    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }
}
