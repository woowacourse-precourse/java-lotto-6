package lotto.util;

import java.util.ArrayList;

public class NumberParser {

    public static ArrayList<Integer> parseWinningNum(String winningNum) {
        ArrayList<Integer> winningNums = new ArrayList<>();
        String[] winningNumStr = winningNum.split(",");

        for (String eachWinningNumStr : winningNumStr) {
            int eachWinningNum = Integer.parseInt(eachWinningNumStr);
            winningNums.add(eachWinningNum);
        }

        return winningNums;
    }
}
