package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.enums.ErrorMessage.*;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    public int readPurchaseAmount() {
        String input = readLine().trim();
        validateEmptyValue(input);
        return Integer.parseInt(input);
    }

    public List<Integer> readWinningNumbers() {
        String input = readLine().trim();
        validateEmptyValue(input);
        List<Integer> winningNumbers = Arrays.stream(input.split(NUMBER_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return winningNumbers;
    }

    public int readBonusNumber() {
        String input = readLine().trim();
        validateEmptyValue(input);
        return Integer.parseInt(input);
    }

    public void validateEmptyValue(String value) throws IllegalArgumentException{
        if (value.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR.getMessage());
        }
    }
}
