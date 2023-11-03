package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputVerifier;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }

    public int getDivisibleNumberInRange(int min, int max, int divisor) {
        String input = readLine();
        InputVerifier.validateIsNumber(input);
        InputVerifier.validateIsNumberInRange(input, min, max);
        InputVerifier.validateIsDivisibleNumber(input, divisor);
        return Integer.parseInt(input);
    }
}
