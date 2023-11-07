package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputWinningNumberView {
    public String inputWinningNum() {
        printWinningNum();
        return Console.readLine();
    }

    public void printWinningNum() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
}
