package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.IllegalArgumentExceptionType;

public class InputView {
    private static final String SPLITTING_REGEX = ",";

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.PARSING_NUMBER_FAIL.getException();
        }
    }

    private long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.PARSING_NUMBER_FAIL.getException();
        }
    }

    public long readCostAmount() {
        return parseLong(Console.readLine());
    }

    private List<Integer> convertWinningNumbers(String input) {
        return Arrays.stream(input.split(SPLITTING_REGEX))
                .map(String::trim)
                .map(this::parseInt)
                .toList();
    }

    public List<Integer> readWinningNumbers() {
        return convertWinningNumbers(Console.readLine());
    }

    public int readBonusNumber() {
        return parseInt(Console.readLine());
    }
}
