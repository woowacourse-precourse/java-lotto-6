package lotto.utils;

import java.util.List;

public class LottoFormatter {
    public String format(List<Integer> numbers) {
        String convertedNumber = convert(numbers);

        return String.join(", ", convertedNumber);
    }

    private String convert(List<Integer> numbers) {
        return String.valueOf(numbers);
    }
}
