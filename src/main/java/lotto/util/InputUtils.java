package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.InputValidationUtils.*;

public class InputUtils {

    public static int readInt() {
        String input = Console.readLine();

        validateHasInput(input);
        validateIsIntFormat(input);

        return Integer.parseInt(input);
    }
}
