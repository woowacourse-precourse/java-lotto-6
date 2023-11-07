package lotto.Model;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputData {
    Lotto winningNumbers;
    InputValidation validation = new InputValidation();

    public int purchase_amount() {
        String input;

        while (true) {
            try {
                input = Console.readLine();
                validation.inputToInt(input);
                validation.check_minusMoney(input);
                validation.check_money(input);

                break;
            } catch (IllegalArgumentException e) {
            }
        }

        return Integer.parseInt(input);
    }

    public Lotto getWinningNumbers() {

        while (true) {
            try {
                String inputNumbers = Console.readLine();
                winningNumbers = new Lotto(stringToList(inputNumbers));
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        return winningNumbers;
    }

    private int input_bonusNumber() {
        String input = Console.readLine();
        int bonusNumber = validation.inputToInt(input);
        validation.checkNumber(bonusNumber);
        winningNumbers.check_bonusNumber(bonusNumber);

        return bonusNumber;
    }

    public int getBonusNumber() {
        int bonusNumber;

        while (true) {
            try {
                bonusNumber = input_bonusNumber();
                break;
            } catch (IllegalArgumentException e) {}
        }

        return bonusNumber;
    }

    public List<Integer> stringToList(String input) throws IllegalArgumentException {

        return Arrays.stream(input.split(","))
                .map(validation::inputToInt)
                .collect(Collectors.toList());
    }

}

