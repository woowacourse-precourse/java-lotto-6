package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.NumberValidator;
import lotto.validator.LottoNumberValidator;

import static lotto.constant.Constant.COMMA_DELIMITER;

public class WinningLottoGenerator {
    private WinningLottoGenerator() {};

    public static List<Integer> generateLottoNumber(final String input){
        List<Integer> numbers = new ArrayList<>();
        for(String number:input.split(COMMA_DELIMITER)){
            NumberValidator.validate(number);
            numbers.add(Integer.parseInt(number));
        }
        LottoNumberValidator.validate_MIN_SIZE(numbers);
        return numbers;
    }
}
