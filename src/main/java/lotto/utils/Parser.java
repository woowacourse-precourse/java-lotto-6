package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.EmptyStringException;
import lotto.exception.InvalidInputNumberException;
import lotto.exception.InvalidNumberScopeException;

public class Parser {
    private static final String DELIMITER = ",";
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;
    public static Integer parseAmountOfMoney(String line) {
        checkEmptyString(line);
        try {
            Integer amount = Integer.parseInt(line);

            return amount;

        } catch (NumberFormatException e) {
            throw new InvalidInputNumberException();
        }
    }

    public static Integer parseLottoBonusNumber(String line) {
        checkEmptyString(line);
        try {
            Integer number = Integer.parseInt(line);
            checkNumberScope(number);

            return number;

        } catch (NumberFormatException e) {
            throw new InvalidInputNumberException();
        }
    }

    public static Lotto parseLotto(String line) {
        List<Integer> numbers = new ArrayList<>();
        checkEmptyString(line);

        String[] tokens = line.split(DELIMITER);
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            numbers.add(number);
        }
        return new Lotto(numbers);
    }

    private static void checkEmptyString(String line) {
        if (line.isEmpty()) {
            throw new EmptyStringException();
        }
    }

    private static void checkNumberScope(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER) {
            throw new InvalidNumberScopeException();
        }
        if (number > MAXIMUM_LOTTO_NUMBER) {
            throw new InvalidNumberScopeException();
        }
    }

}
