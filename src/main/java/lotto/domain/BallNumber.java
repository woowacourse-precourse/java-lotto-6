package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {
    public static String[] inputWinningBall() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningBall = Console.readLine();
        return winningBall.split(",");
    }

    public static List<Integer> transWinningBall(String[] winningBallNumber) {
        List<Integer> winningNumber = new ArrayList<>();

        for (String s : winningBallNumber) {
            winningNumber.add(Integer.parseInt(s));
        }

        return winningNumber;
    }

    public static int inputBonusBall() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusBall = Console.readLine();
        return Integer.parseInt(bonusBall);
    }

}
