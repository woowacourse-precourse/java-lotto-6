package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.system.SystemConstant;
import lotto.system.SystemMessage;
import lotto.validator.InputValidator;

public class InputView {
    public static Long readMoney() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        return Long.valueOf(userInput);
    }

    public static List<Integer> readWinningNumber() {
        Stream<String> userInput = Arrays.stream(
                Console.readLine().split(SystemMessage.WINNING_NUMBER_SEPARATOR.getMessage()));
        userInput.forEach(InputValidator::validate);
        return userInput
                .map(Integer::valueOf)
                .toList();
    }
}
