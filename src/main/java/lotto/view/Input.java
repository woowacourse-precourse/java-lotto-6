package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String purchasePrice() {
        return defaultReadLine();
    }

    private String defaultReadLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
