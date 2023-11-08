package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class ParseUtils {

    public int parseStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_FORMAT_ERROR.getMessage());
        }
    }

    public List<Integer> parseStringToIntegerList(String value) {
        String[] splitValues = value.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String splitValue : splitValues) {
            try {
                numbers.add(Integer.parseInt(splitValue));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR.getMessage());
            }
        }

        return numbers;
    }
}
