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
            String input = InputView.getWinningNumber();

            try {
                winningNumber = new Lotto(getWinningNumber(input));
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(ErrorMessage.WINNING_NUMBER_WRONG.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumber(String input) {
        List<Integer> list = new ArrayList<>();
        String [] numbers = input.split(",");

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            validator.checkWinningNumberRight(num, list);
            list.add(num);
        }

        return list;
    }

    public void makeBonusNumber() {
        bonusNumber = InputView.getBonusNumber();
    }
}
