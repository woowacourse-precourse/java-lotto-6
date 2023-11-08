package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.IntegerParser;

public class Input {

    public static Integer getInteger() {
        try {
            String readLine = getLine();
            return IntegerParser.stringToInteger(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
        }
    }

    public static String getLine() {
        return Console.readLine();
    }
}
