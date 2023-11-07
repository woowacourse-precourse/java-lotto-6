package lotto.Util;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Constant;
import lotto.Domain.LottoNumber;

public class Parser {

    public static List<Integer> parseLottoNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers.split(Constant.NUMBER_DELIMITER)) {
            LottoNumber lottoNumber = new LottoNumber(number);
            numbers.add(lottoNumber.getNumber());
        }
        return numbers;
    }

}
