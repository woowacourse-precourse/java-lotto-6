package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static List<Integer> winningNumberList;

    public static String inputPlayerAmount() {
        System.out.println(Global.BUY_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> numberList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ErrorMessage.typeException();
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputLottoWinningNum() {
        System.out.println(Global.WINNING_NUMBER);
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(Global.BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }


}