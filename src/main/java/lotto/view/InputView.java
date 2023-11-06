package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.view.constant.ErrorMessage.INPUT_INVALID_FORMAT;
import static lotto.view.constant.ErrorMessage.INPUT_IS_NOT_BLANK;
import static lotto.view.constant.viewMessage.*;

public class InputView {

    private static final Pattern COMMAPATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d],+[\\d]+,[\\d]+,[\\d]+$");

    public int inputMoney() {
        System.out.print(INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateBlank(input);
        return intParser(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.print(INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        validateComma(input);
        return separateNumbers(input);
    }

    public Integer inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        validateBlank(input);
        return integerParser(input);
    }

    private static void validateBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_NOT_BLANK);
        }
    }

    private static void validateComma(String input) {
        if (!COMMAPATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_INVALID_FORMAT);
        }
    }

    private static int intParser(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INPUT_INVALID_FORMAT);
        }
    }

    private static int integerParser(String input) {
        try {
            return Integer.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INPUT_INVALID_FORMAT);
        }
    }

    private static List<Integer> separateNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
