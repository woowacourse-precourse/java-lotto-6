package lotto;

import java.util.List;

import static lotto.constants.LottoConfig.NUMBER_LENGTH;

public class Validator {
    public static boolean isUniqueNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .toList().size() == NUMBER_LENGTH.getValue();
    }
}
