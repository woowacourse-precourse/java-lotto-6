package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.ErrorCode;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }


    public Integer requestInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INPUT_NOT_INTEGER.getMessage());
        }
    }

    public List<Integer> requestIntegers() {
        try {
            return Stream.of(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INPUT_NOT_INTEGERS.getMessage());
        }
    }
}
