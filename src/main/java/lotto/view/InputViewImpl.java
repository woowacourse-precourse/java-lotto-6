package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Validation;

public class InputViewImpl implements InputView {
    private final String DELIMITER = ",";
    private final Validation validation;

    public InputViewImpl(Validation validation) {
        this.validation = validation;
    }

    @Override
    public List<Integer> insertWinningNumbers() {
        String input;
        do {
            input = Console.readLine();
        } while (validation.isValidWinningNumbers(input));
        return convertToNumbers(input);
    }

    private List<Integer> convertToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] strings = input.split(DELIMITER);
        for (String string : strings) {
            numbers.add(Integer.parseInt(string));
        }
        return numbers;
    }

    @Override
    public int insertBonusNumber(List<Integer> winningNumbers) {
        String input;
        do {
            input = Console.readLine();
        } while (validation.isValidBonusNumber(input, winningNumbers));
        return Integer.parseInt(input);
    }

    @Override
    public int insertMoney() {
        String input;
        do {
            input = Console.readLine();
        } while (validation.isValidMoney(input));
        return Integer.parseInt(input);
    }
}
