package utils;

import java.util.Arrays;
import java.util.List;
import lotto.LottoNumber;

public class Parser {
    public static List<LottoNumber> stringToLottoNumbers(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .toList();
    }
}
