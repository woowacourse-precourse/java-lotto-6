package View;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class WinnerInput {
    private static List<Integer> winnerCode;


    public static List<Integer> getWinner() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<String> temp= Arrays.asList(Console.readLine().split(","));
            for (String s : temp) {
                winnerCode.add(parseInt(s));
            }
            checkRange(winnerCode);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);
            getWinner();
        }
        return winnerCode;
    }

    private static List<Integer> checkRange(List<Integer> winnerCode) {
        try {
            if (Collections.min(winnerCode) <=0 || Collections.max(winnerCode)>46){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);
            return getWinner();
        }
        return winnerCode;
    }
}
