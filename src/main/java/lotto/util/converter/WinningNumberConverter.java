package lotto.util.converter;

import java.util.List;
import lotto.util.exception.InvalidLottoNumbersException;

public class WinningNumberConverter {
    private static final String delimiter = ",";

    private WinningNumberConverter() {
    }

    public static List<Integer> convert(String input) {
        try {
            List<String> splitInput = List.of(input.split(delimiter, -1));
            return splitInput.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumbersException(input, e);
        }
    }
}
