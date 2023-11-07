package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputDevice implements Readable {
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
