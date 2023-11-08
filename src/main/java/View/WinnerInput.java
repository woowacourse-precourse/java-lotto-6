package View;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class WinnerInput {
    private static List<Integer> winnerCode;
    private static int bonus;

    public static List<Integer> getWinner() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<String> temp = Arrays.asList(Console.readLine().split(","));
            for (String s : temp) {
                winnerCode.add(parseInt(s));
            }
        } catch (NumberFormatException e) {
            winnerCode.clear();
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);
            getWinner();
        }
        return winnerCode;

    }
}
/*
    public static int getWinnerBonus() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            int bonus = parseInt(Console.readLine());
            checkValid();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);
            getWinnerBonus();
        }
        return bonus;

    }
    private static int checkValid() {
        try {
            if(bonus<=0)
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);;
        }
        return winnerCode;

    }
}
*/