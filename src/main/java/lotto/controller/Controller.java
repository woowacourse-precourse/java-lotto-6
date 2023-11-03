package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        part1();
    }

    public void part1() {
        OutputView.printBuyInputPrice();
        String userInput = InputView.userInput();
        int userPrice = InputView.userInputParsedInt(userInput);
        int lottoCnt = userPrice / 1000;
        OutputView.printBuyLottoCount(lottoCnt);
    }

}
