package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        String input = Console.readLine();
        return Validation.isValidPurchaseAmount(input);
    }

    public static List<Integer> getWinnerNumbers() {
        String input = Console.readLine();
        return Validation.isValidWinnerNumbers(input);
    }
}
