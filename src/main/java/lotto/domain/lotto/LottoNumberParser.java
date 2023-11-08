package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.io.ErrorMessage.VALUE_NOT_INTEGER;

public class LottoNumberParser {
    private static final String DELIMETER = ",";

    public Lotto parseNumber(String lottoNumber) {
        List<Integer> numbers = trim(split(lottoNumber));

        return new Lotto(numbers);
    }

    private String[] split(String lottoNumber) {
        return lottoNumber.split(DELIMETER);
    }

    private List<Integer> trim(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALUE_NOT_INTEGER.getMessage());
        }
    }

}
