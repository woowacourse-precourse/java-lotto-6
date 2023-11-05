package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Draw {

    private void getWinningLottoNumsList() {
        printWinningLottoNumsEnterGuideStatement();
        String input = Console.readLine();
    }

    private void printWinningLottoNumsEnterGuideStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
