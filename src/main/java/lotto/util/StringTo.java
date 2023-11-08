package lotto.util;

import static lotto.util.Verify.inputVerifyToStringArray;

import java.util.List;
import lotto.Model.Lotto;

public class StringTo {

    public static Lotto stringToLotto(String input){
        List<Integer> numbers = inputVerifyToStringArray(input);
        return new Lotto(numbers);
    }
}
