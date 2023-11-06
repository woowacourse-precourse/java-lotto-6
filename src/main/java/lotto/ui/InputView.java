package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private InputValidator inputValidator = new InputValidator();

    public int getAmount() {
        int amount = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = Console.readLine();
            try {
                amount = inputValidator.validateAmount(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            String input = Console.readLine();
            try {
                winningNumbers = inputValidator.validateWinningNumbers(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = Console.readLine();
            try {
                bonusNumber = inputValidator.validateBonusNumber(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}