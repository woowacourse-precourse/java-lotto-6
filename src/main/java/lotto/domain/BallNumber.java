package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {
    public static boolean canUse = true;
    public static boolean bonusBallCanUse = true;

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
        //Lotto lotto = new Lotto(winningNumber);

        return winningNumber;
    }

    public static boolean validate(List<Integer> param) {
        canUse = false;
        Lotto lotto = new Lotto(param);
        return canUse;
    }

    public static int inputBonusBall() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusBall = Console.readLine();
        return Integer.parseInt(bonusBall);
    }

    //보너스 볼 중복 확인
    public static boolean checkBonusBall(List<Integer> param, int inputNum) {
        boolean result = false;
        try {
            result = param.contains(inputNum);
            if (result) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }


        return result;
    }

}
