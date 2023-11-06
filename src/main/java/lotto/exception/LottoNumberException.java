package lotto.exception;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.LottoNumberRangeException.NumberRangeException;

public class LottoNumberException {
    public static List<Integer> LottoNumberException(String input) {
        List<Integer> lotto_numbers = new ArrayList<>();
        String[] numberStrings = input.split(",");
        for (String numberString : numberStrings) {
            ValueException.validateNumber(numberString);
            int number = Integer.parseInt(numberString);
            LottoNumberRangeException.NumberRangeException(number);
            lotto_numbers.add(number);
        }
        return lotto_numbers;
    }
}

