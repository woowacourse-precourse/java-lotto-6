package lotto.model;

import java.util.Arrays;
import java.util.List;

public class ConverterModel {
    private static final String DELIMITER = ",";

    public Integer purchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(purchaseAmount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> StringToIntList(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
