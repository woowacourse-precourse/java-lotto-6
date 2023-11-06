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
    
    private static int inputNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT.get());
        }
    }

    public List<Integer> winningNumbers() {
        return Arrays.stream(readLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public int bonusNumber() {
        return inputNumber();
    }
}
