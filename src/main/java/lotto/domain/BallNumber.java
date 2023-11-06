package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BallNumber {
    public static String[] inputWinningBall() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningBall = Console.readLine();
        return winningBall.split(",");
    }

}
