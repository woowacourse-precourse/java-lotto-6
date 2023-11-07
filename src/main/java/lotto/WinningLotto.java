package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.InputException;
import lotto.view.Input;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this.winningNumbers = initializeWinningNumbers(winningNumbers);
        this.bonusNumber = initializeBonusNumber(bonusNumber);
    }

    private List<Integer> initializeWinningNumbers(String input) {
        final List<Integer> inputNumbers;

        try {
            stringInputValidate(input);
            inputNumbers = parseNumbers(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return initializeWinningNumbers(Input.winningNumbers());
        }

        return inputNumbers;
    }

    private List<Integer> parseNumbers(final String input) {
        final List<Integer> numbers = new ArrayList<>();

        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number));
        }

        listValidate(numbers);

        return numbers;
    }

    private int initializeBonusNumber(final String input) {

        try {
            bonusNumberValidate(input, this.winningNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return initializeBonusNumber(Input.bonusNumber());
        }

        return Integer.parseInt(input);
    }

    public final List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public final int getBonusNumber() {
        return bonusNumber;
    }

    private void stringInputValidate(final String input) {
        InputException.blankInput(input);
        InputException.onlyComma(input);
        InputException.cannotParseToInt(input);
    }

    private void listValidate(final List<Integer> input) {
        InputException.notSixNumberInput(input);
        InputException.wrongNumberRange(input);
        InputException.numberDuplicate(input);
    }

    private void bonusNumberValidate(final String input, final List<Integer> winningNumbers) {
        InputException.blankInput(input);
        InputException.notNumber(input);
        InputException.wrongNumberRange(input);
        InputException.isDuplicatedWithWinningNumbers(input, winningNumbers);
    }
}
