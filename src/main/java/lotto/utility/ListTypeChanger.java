package lotto.utility;

import java.util.ArrayList;
import java.util.List;

public class ListTypeChanger {
    public static List<Integer> changeListType(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            int number = parseNumber(part);
            numbers.add(number);
        }

        return numbers;
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }

}
