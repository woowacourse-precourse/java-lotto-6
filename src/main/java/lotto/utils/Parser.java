package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.EmptyStringException;
import lotto.exception.InvalidInputNumberException;

public class Parser {
    private static final String DELIMITER = ",";
    public static Integer parseAmountOfMoney(String line) {
        checkEmptyString(line);
        try {
            Integer amount = Integer.parseInt(line);

            return amount;

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

}
