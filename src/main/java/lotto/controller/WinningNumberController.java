package lotto.controller;

import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.controller.LotteryGameController.*;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberController {

    private final static String SPLIT_SYMBOL = ",";
    private final InputView inputView = new InputView();

    void inputWinningNumberStage() {
        requestWinningNumber();
        requestBonusNumber();
    }

    private void requestBonusNumber() {
        OutputView.printNewLine();
        OutputView.requestBonusNumberMessage();
        String input = inputView.returnInput();
        bonusNumber = new BonusNumber(Integer.parseInt(input));
    }

    private void requestWinningNumber() {
        OutputView.requestWinningNumberMessage();
        winningLotto = new Lotto(inputWinningNumber());
    }

    private List<Integer> inputWinningNumber() {
        String input = inputView.returnInput();
        String[] numberStrings = input.split(SPLIT_SYMBOL);

        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }

        return numbers;
    }
}
