package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS = "보너스 번호를 입력해 주세요.";

    private static List<Integer> winningNumber;
    public static String inputPlayerAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> inputPlayerWinning() {
        System.out.println("\n" + INPUT_LOTTO_WINNING);
        return numberList(Console.readLine());
    }

    public static int inputPlayerBonus() {
        System.out.println("\n" + INPUT_LOTTO_BONUS);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String winningNum) {
        String[] result = winningNum.split(",");
        winningNumber = new ArrayList<>();
        for(int i = 0; i <result.length; i++) {
            winningNumber.add(changeToInt(result[i]));
        }
        return winningNumber;
    }

    private static int changeToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch(NumberFormatException e) {
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }
}
