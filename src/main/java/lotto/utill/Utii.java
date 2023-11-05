package lotto.utill;

import Validate.ValidateException;
import camp.nextstep.edu.missionutils.Console;

public class Utii {
    public static boolean isSameInt(Integer num_1, Integer num_2) {
        return num_2 == num_1;
    }

    public static String InputStringLine() {
        String inputStringLine = Console.readLine().trim();

        ValidateException.includeString(inputStringLine);

        return inputStringLine;
    }
}
