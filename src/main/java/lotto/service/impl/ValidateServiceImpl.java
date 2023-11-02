package lotto.service.impl;

import java.util.Arrays;
import java.util.List;
import lotto.exception.DifferentUnitFormatException;
import lotto.exception.WrongBlankException;
import lotto.exception.WrongCommasFormatException;
import lotto.exception.WrongTypeFormatException;
import lotto.service.ValidateService;

public class ValidateServiceImpl implements ValidateService {
    private static Integer checkIncludeChar(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeFormatException();
        }
    }

    private static void checkBlankInput(String input) {
        if (input.equals("")) {
            throw new WrongBlankException();
        }
    }

    private static void checkCorrectCommas(String input, List<String> inputStream) {
        long count = countCommas(input);
        if (count != 5 || inputStream.size() != 6) {
            throw new WrongCommasFormatException();
        }
    }

    private static long countCommas(String input) {
        return input.chars().filter(ch -> ch == ',').count();
    }

    @Override
    public void checkCorrectMoneyInput(String input) {
        Integer money = checkIncludeChar(input);
        if (money % 1000 != 0) {
            throw new DifferentUnitFormatException();
        }
    }

    @Override
    public List<Integer> checkCorrectWinnerNumbersInput(String input) {
        checkBlankInput(input);
        List<String> inputStream = Arrays.asList(input.split(","));
        checkCorrectCommas(input, inputStream);
        try {
            return inputStream.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeFormatException();
        }
    }
}
