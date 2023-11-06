package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BallNumber {
    public static String[] inputWinningBall() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningBall = Console.readLine();
        return winningBall.split(",");
    }

    public static int[] transWinningBall(String[] winningBallNumber) {
        int[] winningNumber = new int[winningBallNumber.length];

        for (int i = 0; i < winningBallNumber.length; i++) {
            winningNumber[i] = Integer.parseInt(winningBallNumber[i]);
        }

        return winningNumber;
    }

    public static int inputBonusBall() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusBall = Console.readLine();
        return Integer.parseInt(bonusBall);
    }

}
