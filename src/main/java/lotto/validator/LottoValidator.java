package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ConstantNumber;

public class LottoValidator extends Validator {
    public static void isAllNumeric(List<String> list) {
        for (String s : list) {
            isNumeric(s);
        }
    }

    public static void containsSixNumbers(int listSize) {
        if (listSize != ConstantNumber.PROPER_LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void haveValidateRange(List<Integer> list) {
        list.forEach(i -> isLottoNumberRange(Integer.toString(i)));
    }

    public static void haveDuplicateNumber(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        if (set.size() != ConstantNumber.PROPER_LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
