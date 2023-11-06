package lotto.controller;

import lotto.util.Utils;
import lotto.view.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    public void run() {
        // TODO: 11/6/23
    }

    private void BeforeLottoGame() {

    }

    private int getInputAmount() {
        InputMessage.MoneyInputMessage();
        String userInput = readLine();
        return Utils.stringToInteger(userInput);
    }

}
