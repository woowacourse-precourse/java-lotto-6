package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public int inputNumber() {
        return InputViewConvertor.parseInt(input());
    }

    @Override
    public List<Integer> inputNumbers() {
        String[] inputValues = input().split(InputViewConfig.NUMBERS_DELIMITER.getValue());
        return Arrays.stream(inputValues)
                .map(InputViewConvertor::parseInt)
                .toList();
    }

    private String input() {
        return Console.readLine();
    }

}
