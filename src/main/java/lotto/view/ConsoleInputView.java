package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputErrorCode;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    @Override
    public Integer inputNumber() {
        String line = Console.readLine().trim();
        return toInteger(line);
    }

    @Override
    public List<Integer> inputNumbersSplitByComma() {
        String line = Console.readLine().trim();
        String[] l = line.split(",");

        return Arrays.stream(l)
                .map(this::toInteger)
                .toList();
    }


    private Integer toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(InputErrorCode.INVALID_NUMERIC_INPUT.getMessage());
        }
    }
}
