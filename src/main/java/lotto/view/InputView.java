package lotto.view;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int readPurchaseMoney() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    public static ArrayList<Integer> readWinningNum() {
        return parseWinningNum(readLine());
    }

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
