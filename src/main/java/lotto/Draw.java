package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Draw {

    private void getWinningLottoNumsList() {
        printWinningLottoNumsEnterGuideStatement();
        String input = Console.readLine();
        String[] strings = input.split(",");
    }

    void isInt(String str) {
        String regex = "^[0-9]+$";
        if (!str.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void printWinningLottoNumsEnterGuideStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
