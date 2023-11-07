package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    int inputAmount() {
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
    }
}
