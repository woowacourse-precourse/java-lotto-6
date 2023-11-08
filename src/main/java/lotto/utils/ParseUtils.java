package lotto.utils;

import lotto.constants.ErrorMessage;
import lotto.constants.Value;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

    public int parseStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TYPE_FORMAT.getMessage());
        }
    }

    public List<Integer> parseStringToIntegerList(String value) {
        String[] splitValues = value.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String splitValue : splitValues) {
            try {
                numbers.add(Integer.parseInt(splitValue));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
            }
        }

        return numbers;
    }
}
