package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public int inputPurchaseAmount() {
        String input = readLine();

        return Integer.parseInt(input);
    }
}
