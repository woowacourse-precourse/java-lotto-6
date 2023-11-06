package lotto.util;

import static lotto.util.Utils.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<Integer> validateLottoNumber(String input) { // 1,2,3,4,5,6
        List<String> strings = splitByComma(input);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : strings) {
            lottoNumbers.add(Integer.parseInt(str));
        }
        return lottoNumbers;
    }

    public static int validateBonusNumber(String input) {
        return parseInt(input);
    }
}