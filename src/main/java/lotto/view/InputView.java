package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputVerifier;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }

    public int getOneNumberInRange(int min, int max) {
        String input = readLine();
        InputVerifier.validateIsNumberInRange(input, min, max);
        return Integer.parseInt(input);
    }
}
