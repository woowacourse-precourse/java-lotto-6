package lotto.view;

import static lotto.errorMessage.ExceptionErrorMessage.INPUT_ONLY_NUMBER_LOTTO;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String comma = ",";

    public static String inputAmount() {
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumber() {
        try {
            return numberList(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER_LOTTO);
        }
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }

    public static List<Integer> numberList(String winningNumber) {
        List<String> str = List.of(winningNumber.split(comma));
        List<Integer> winnerNumberList = new ArrayList<>();
        for (String s : str) {
            winnerNumberList.add(Integer.valueOf(s));
        }

        return winnerNumberList;
    }
}
