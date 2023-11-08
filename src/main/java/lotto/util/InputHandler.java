package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String INPUT_INIT_VAL = "";
    private static final boolean FLAG_INIT_VAL = true;
    private static final String ERROR_FLAG = "ERROR";
    private static final String SEPARATOR = ",";
    private static final InputValidator validator = new InputValidator();

    public int inputMoney() {
        String input = INPUT_INIT_VAL;
        boolean flag = FLAG_INIT_VAL;
        while (flag) {
            input = inputMoneyExceptionHandler();
            flag = detectErrorOccurring(input);
        }

        return Integer.parseInt(input);
    }

    private String inputMoneyExceptionHandler() {
        String input;
        try {
            input = Console.readLine();
            validator.validateMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ERROR_FLAG;
        }
        return input;
    }

    public List<Integer> inputHitNumbers() {
        String input = INPUT_INIT_VAL;
        boolean flag = FLAG_INIT_VAL;
        while (flag) {
            input = inputHitNumbersExceptionHandler();
            flag = detectErrorOccurring(input);
        }

        return convertStringToIntegerList(input);
    }

    private String inputHitNumbersExceptionHandler() {
        String input;
        try {
            input = Console.readLine();
            validator.validateHitNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ERROR_FLAG;
        }
        return input;
    }

    public int inputBonusNumber() {
        String input = INPUT_INIT_VAL;
        boolean flag = FLAG_INIT_VAL;
        while (flag) {
            input = inputBonusNumberExceptionHandler();
            flag = detectErrorOccurring(input);
        }

        return Integer.parseInt(input);
    }

    private String inputBonusNumberExceptionHandler() {
        String input;
        try {
            input = Console.readLine();
            validator.validateBonusNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ERROR_FLAG;
        }
        return input;
    }

    private boolean detectErrorOccurring(String input) {
        return Objects.equals(input, ERROR_FLAG);
    }

    private List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(number -> Integer.parseInt(number.strip()))
                .collect(Collectors.toList());
    }
}
