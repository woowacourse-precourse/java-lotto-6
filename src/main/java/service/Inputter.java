package service;

import camp.nextstep.edu.missionutils.Console;

public class Inputter {
    Outputter outputter = new Outputter();

    public String inputPurchaseAmount() {
        outputter.promptPurchaseAmount();
        String input = Console.readLine();
        return input;
    }

    public String inputWinningNumbers() {
        String input = Console.readLine();

        return input;
    }

    public String inputBonusNumber() {
        String input = Console.readLine();

        return input;
    }

}
