package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Utils;
import view.InputView;

public class Controller {

    private int getPurchaseAmount() {
        System.out.println(InputView.INPUT_PURCHASE_AMOUNT);
        String userInput = Console.readLine().trim();
        return Utils.stringToInteger(userInput);
    }
}
