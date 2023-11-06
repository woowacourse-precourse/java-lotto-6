package lotto.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Input {

    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    private static Input input;

    public Input() {
    }

    public static Input getInstance() {
        if (input == null) {
            input = new Input();
        }
        return input;
    }

    public int inputPurchaseAmount() {
        String amount = readLine();
        return Integer.parseInt(amount);
    }

    public List<Integer> inputNumbers() {
        String numbers = readLine();
        return Arrays.stream(numbers.split(SEPARATOR)).sorted().mapToInt(Integer::getInteger).boxed().toList();
    }

    public int inputBonusNumber() {
        String number = readLine();
        return Integer.parseInt(number);
    }

}
