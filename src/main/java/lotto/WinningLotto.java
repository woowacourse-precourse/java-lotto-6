package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.validation.InputException;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto() {
        this.winningNumbers = initializeWinningNumbers();
        System.out.println(Constant.bonusNumber);
        this.bonusNumber = initializeBonusNumber();
    }

    private List<Integer> initializeWinningNumbers() {
        final List<Integer> inputNumbers;
        final String input = Console.readLine();

        try {
            stringInputValidate(input);
            inputNumbers = parseNumbers(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return initializeWinningNumbers();
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

    private int initializeBonusNumber() {
        final String input = Console.readLine();

        try {
            bonusNumberValidate(input, this.winningNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return initializeBonusNumber();
        }

        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
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
