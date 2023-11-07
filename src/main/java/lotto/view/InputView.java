package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static String getUserInput() {
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumbers() {
        String userInput = Console.readLine();
        return Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
    }

    public static Integer inputBonusNumber() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
