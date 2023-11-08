package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";
    private final LottoValidator lottoValidator;

    public Parser(LottoValidator lottoValidator) {
        this.lottoValidator = lottoValidator;
    }

    public List<Integer> parseNumbers(String input) {
        String[] numbers = input.split(DELIMITER);
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(this::convertToInt)
                .toList();
    }

    private Integer convertToInt(String number) {
        return lottoValidator.validateNonNumeric(number);
    }
}
