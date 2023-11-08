package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.EmptyStringException;
import lotto.exception.InvalidLottoFormatException;
import lotto.exception.InvalidNumberFormatException;

public class Parser {
    private static final String DELIMITER = ",";

    public static Integer parseAmountOfMoney(String line) {

        checkEmptyString(line);

        try {
            Integer amount = Integer.parseInt(line);

            return amount;
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }

    }

    public static Integer parseLottoBonusNumber(String line) {

        checkEmptyString(line);

        try {
            Integer number = Integer.valueOf(line);

            return number;
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }

    }

    public static Lotto parseLotto(String line) {

        checkEmptyString(line);

        List<Integer> numbers = new ArrayList<>();
        String[] tokens = line.split(DELIMITER);

        try {
            for (String token : tokens) {
                Integer number = Integer.valueOf(token);
                numbers.add(number);
            }

        } catch (NumberFormatException e) {
            throw new InvalidLottoFormatException();
        }

        return new Lotto(numbers);
    }

    private static void checkEmptyString(String line) {
        if (line.isEmpty()) {
            throw new EmptyStringException();
        }
    }

}
