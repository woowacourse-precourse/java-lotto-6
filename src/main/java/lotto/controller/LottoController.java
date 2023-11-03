package lotto.controller;

import java.util.*;
import java.util.stream.Collectors;
import lotto.exception.InputException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = receiveMoney();
        List<Integer> winningNumbers = receiveWinningNumbers();
        int bonusNumber = receiveBonusNumber();
    }

    private int receiveMoney() {
        outputView.printInputMoneyMessage();
        try {
            return inputView.inputMoney();
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return receiveMoney(); // 재귀
        }
    }

    private List<Integer> receiveWinningNumbers() {
        outputView.printInputWinningNumbersMessage();
        try {
            return parseWinningNumbers(inputView.inputWinningNumber());
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return receiveWinningNumbers(); // 재귀
        }
    }

    private List<Integer> parseWinningNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputException();
        }
    }

    private int receiveBonusNumber() {
        outputView.printInputBonusNumberMessage();
        try {
            return inputView.inputBonusNumber();
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return receiveBonusNumber(); // 재귀
        }
    }
}
