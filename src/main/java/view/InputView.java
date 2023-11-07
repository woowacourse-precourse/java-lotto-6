package view;

import constant.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER = ",";
    public int purchaseAmount() {
        return inputNumber();
    }
    
    private int inputNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT.get());
        }
    }

    public List<Integer> winningNumbers() {
        try {
            return Arrays.stream(readLine().split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT.get());
        }
    }

    public int bonusNumber() {
        return inputNumber();
    }
}
