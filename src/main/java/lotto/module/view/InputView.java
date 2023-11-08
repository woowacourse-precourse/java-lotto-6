package lotto.module.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.global.utils.Validator;

public class InputView {

    private static final String SEPARATOR = ",";

    public static Long readPurchaseAmount() {
        String input = readLine();
        Validator.validatePurchaseAmount(input);
        return Long.parseLong(input);
    }

    public static List<Integer> readWinningNumbers() {
        String input = readLine();
        List<String> numbers = separateNumbers(input);
        Validator.validateWinningNumbers(numbers);
        return numbers.stream().map(s -> Integer.parseInt(s)).toList();
    }

    private static List<String> separateNumbers(String input) {
        List<String> numbers = new ArrayList<>();
        String[] arr = input.split(SEPARATOR);
        numbers.addAll(List.of(arr));
        return numbers;
    }
}
