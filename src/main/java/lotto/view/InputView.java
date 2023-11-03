package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {

    public Integer inputMoney() {
        try {
            OutputView.moneyMessage();
            String money = Console.readLine();

            Validator.moneyValidate(money);

            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            return inputMoney();
        }
    }

    public ArrayList<Integer> winningNumber() {
        try {
            OutputView.winningMessage();
            String[] winningNumber = Console.readLine().split(",");

            Validator.winningValidate(winningNumber);

            return createWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            return winningNumber();
        }
    }

    public Integer bonusNumber(ArrayList<Integer> winningNumber) {
        try {
            OutputView.bonusMessage();
            String bonusNumber = Console.readLine();

            Validator.bonusValidate(bonusNumber, winningNumber);

            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            return bonusNumber(winningNumber);
        }
    }

    private ArrayList<Integer> createWinningNumber(String[] winningNumber) {
        return new ArrayList<>(Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .toList());
    }
}
