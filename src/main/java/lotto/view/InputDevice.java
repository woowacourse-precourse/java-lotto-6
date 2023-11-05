package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputDevice implements Inputable {
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
