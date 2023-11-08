package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Input {

    public static Integer getInteger() {
        try {
            String readLine = getLine();
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
        }
    }

    public static String getLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] " + e.getMessage());
        }
    }
}
