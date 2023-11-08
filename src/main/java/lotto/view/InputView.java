package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.enums.ErrorMessage.*;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    public InputView() {
    }

    public int readPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(readLine().trim());
        return purchaseAmount;
    }

    public List<Integer> readWinningNumbers() {
        String numbers = readLine().trim();
        validateEmptyValue(numbers);
        List<Integer> winningNumbers = Arrays.stream(numbers.split(NUMBER_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return winningNumbers;
    }

    public int readBonusNumber() {
        int bonusNumber = Integer.parseInt(readLine());
        return bonusNumber;
    }

    public void validateEmptyValue(String value) throws IllegalArgumentException{
        if (value.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR.getMessage());
        }
    }
}
