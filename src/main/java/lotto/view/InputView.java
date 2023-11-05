package lotto.view;

import static lotto.utils.ExceptionMessage.INPUT_ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int inputInteger() {
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
        }
    }

    public List<Integer> inputWinNumbers() {
        return new ArrayList<>(Arrays.stream(Console.readLine().split(",")).map(Integer::valueOf).toList());
    }
}
