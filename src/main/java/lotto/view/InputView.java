package lotto.view;

import static lotto.utils.ExceptionMessage.NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int inputInteger() {
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
            System.out.println();
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalStateException(NOT_NUMBER.getMessage());
        }
    }

    public List<Integer> inputWinNumbers() {
        List<Integer> winNumbers = new ArrayList<>(
                Arrays.stream(Console.readLine().split(","))
                        .map(Integer::valueOf)
                        .toList());
        System.out.println();
        return winNumbers;
    }
}
