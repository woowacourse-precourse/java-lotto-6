package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private final InputValidator inputValidator = new InputValidator();

    public int getUserAmount() {
        String userInput = Console.readLine();
        inputValidator.validateUserInput(userInput);
        return Integer.parseInt(userInput);
    }

    public List<Integer> getWinningNumbers() {
        List<String> userInput = Arrays.asList(Console.readLine().split(Constants.COMMA));
        inputValidator.validateWinningNumbers(userInput);

        return userInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        String userInput = Console.readLine();
        inputValidator.validateBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
