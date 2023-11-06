package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private final InputValidator inputValidator = new InputValidator();

    public String getUserAmount() {
        return Console.readLine();
    }

    public List<String> getWinningNumbers() {
        return Arrays.asList(Console.readLine().split(Constants.COMMA));
    }

    public int getBonusNumber() {
        String userInput = Console.readLine();
        inputValidator.validateBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
