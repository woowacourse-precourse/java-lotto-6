package lotto.util;

import java.util.List;

public class Converter {

    public static List<Integer> convertToIntList(List<String> numbers) {
        return numbers.stream()
                .mapToInt(number -> Validator.validateNumeric(number))
                .boxed()
                .toList();
    }

}
