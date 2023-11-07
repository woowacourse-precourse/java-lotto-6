package lotto.util;

import lotto.domain.Lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static lotto.util.Validate.checkDuplicated;
import static lotto.util.Validate.checkWinningNumberValidate;

public class LottoUtil {
    public static Lotto convertList(String lotto) {
        List<String> numbers = new ArrayList<>(Arrays.asList(lotto.split(",")));
        List<Integer> result = numbers.stream().map(number ->
            checkWinningNumberValidate(number)).toList();
        checkDuplicated(numbers, result);
        return new Lotto(result);
    }
}
