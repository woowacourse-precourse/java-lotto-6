package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    protected boolean isInvalidInput = true;
    public String getInput() {
        return Console.readLine();
    }
}
