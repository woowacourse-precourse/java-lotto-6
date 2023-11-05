package lotto.utils.validator;

import java.util.List;

public class NumberValidator {
    public static void duplicateBonusNumberCheck(List<Integer> integers, int bonus) throws IllegalArgumentException {
        if (integers.contains(bonus)) {
            throw new IllegalArgumentException("당첨 리스트의 번호와 보너스 번호가 중복됩니다.");
        }
    }

}
