package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputDevice {
    private InputDevice() {
    }

    public static int receiveNumber() {
        return InputHandler.parseInputNumber(Console.readLine());
    }

    public static List<Integer> receiveNumbers() {
        return InputHandler.parseInputNumbers(Console.readLine());
    }
}
