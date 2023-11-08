package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.constant.ErrorMessage;
import lotto.validation.Validator;

public class DrawMachine {
    private Lotto winningNumber;
    private int bonusNumber;
    Validator validator = new Validator();

    public void makeWinningNumber() {
        while (true) {
            String input = InputView.getWinningNumberInput();

            try {
                setWinningNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.WINNING_NUMBER_WRONG.getMessage());
            }
        }
    }

    private void setWinningNumber(String input) {
        List<Integer> list = new ArrayList<>();
        String [] numbers = input.split(",");

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            validator.checkWinningNumberRight(num, list);
            list.add(num);
        }

        winningNumber = new Lotto(list);
    }

    public void makeBonusNumber() {
        while (true) {
            String input = InputView.getBonusNumberInput();

            try {
                setBonusNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.BONUS_NUMBER_WRONG.getMessage());
            }
        }
    }

    private void setBonusNumber(String input) {
        int num = Integer.parseInt(input);

        validator.checkBonusNumberRight(num, winningNumber);

        bonusNumber = num;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
