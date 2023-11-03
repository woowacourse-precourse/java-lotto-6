package lotto.model;

import lotto.ErrorMessages;

import java.util.Arrays;
import java.util.List;

public class ConverterModel {
    private static final String DELIMITER = ",";

    public Integer StringToInt(String purchaseAmount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(purchaseAmount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER.toString());
        }
    }

    public List<Integer> StringToIntList(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
