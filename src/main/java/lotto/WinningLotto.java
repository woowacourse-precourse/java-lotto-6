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
        this.bonusNumber = initializeBonusNumber();
    }

    private List<Integer> initializeWinningNumbers() {
        List<Integer> inputNumbers;
        String input = Console.readLine();

        try {
            stringInputValidate(input);
            inputNumbers = parseNumbers(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.err.println(illegalArgumentException.getMessage());
            return initializeWinningNumbers();
        }

        return inputNumbers;
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        listValidate(numbers);

        return numbers;
    }

    private int initializeBonusNumber() {
        System.out.println(Constant.bonusNumber);
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void stringInputValidate(String input) {
        InputException.blankInput(input);
        InputException.onlyComma(input);
        InputException.cannotParseToInt(input);
    }

    private void listValidate(List<Integer> input) {
        InputException.notSixNumberInput(input);
        InputException.wrongNumberRange(input);
        InputException.numberDuplicate(input);
    }
}
