package lotto.controller;

import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoDraw {

    public void drawLotto (InputView inputView) {
        String[] winningNumbers;

        inputView.showWinningNumbersInputForm();
        winningNumbers = readLine().split(",");
    }
}
