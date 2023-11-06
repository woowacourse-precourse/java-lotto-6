package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.NumberValidator;
import lotto.validator.WinningLottoNumberValidator;

import static lotto.constant.Constant.COMMA_DELIMITER;

public class WinningLottoGenerator {
    private WinningLottoGenerator() {};

    public static List<Integer> generateLottoNumber(final String input){
        List<Integer> numbers = new ArrayList<>();
        for(String number:input.split(COMMA_DELIMITER)){
            int change_integer_number = NumberValidator.validate(number);
            numbers.add(change_integer_number);
        }
        WinningLottoNumberValidator.validate_MIN_SIZE(numbers);
        return numbers;
    }
}
