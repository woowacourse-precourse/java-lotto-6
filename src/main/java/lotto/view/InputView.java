package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Validator.*;

public class InputView {
    public static String inputNumber() {
        String input = readLine();

        validateHasSpace(input);
        validateCommaStartEnd(input);

        return input;
    }
}
