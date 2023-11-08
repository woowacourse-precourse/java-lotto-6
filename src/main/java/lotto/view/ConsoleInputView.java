package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (l.length == 0) {
            throw new IllegalArgumentException("SDFDSF");
        }
        List<Integer> numbers = Arrays.stream(l)
                .map(this::toInteger)
                .toList();
        checkUnique(numbers);

        return numbers;
    }


    private Integer toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(InputErrorCode.INVALID_NUMERIC_INPUT.getMessage());
        }
    }

    private void checkUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(InputErrorCode.SHOULD_BE_UNIQUE.getMessage());
        }
    }

}
