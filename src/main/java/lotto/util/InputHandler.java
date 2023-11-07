package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.HitNumbers;

public class InputHandler {
    private static final String SEPARATOR = ",";
    private static final InputValidator validator = new InputValidator();

    public int inputMoney() {
        String input = "";
        boolean flag = true;
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
            return "ERROR";
        }
        return input;
    }

    public List<Integer> inputHitNumbers() {
        String input = "";
        boolean flag = true;
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
            return "ERROR";
        }
        return input;
    }

    public int inputBonusNumber(HitNumbers hitNumbers) {
        String input = "";
        boolean flag = true;
        while (flag) {
            input = inputBonusNumberExceptionHandler(hitNumbers);
            flag = detectErrorOccurring(input);
        }

        return Integer.parseInt(input);
    }

    private String inputBonusNumberExceptionHandler(HitNumbers hitNumbers) {
        String input;
        try {
            input = Console.readLine();
            validator.validateBonusNumber(input, hitNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "ERROR";
        }
        return input;
    }

    private boolean detectErrorOccurring(String input) {
        return Objects.equals(input, "ERROR");
    }

    private List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(number -> Integer.parseInt(number.strip()))
                .collect(Collectors.toList());
    }
}
