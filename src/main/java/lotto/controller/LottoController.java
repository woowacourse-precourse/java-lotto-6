package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.utils.Utills;
import lotto.view.InputView;

public class LottoController {

    public void run() {

    }

    private int getInputAmount() {
        InputView.inputAmount();
        String userInput = readLine().trim();
        return Utills.stringToInteger(userInput);
    }
}
