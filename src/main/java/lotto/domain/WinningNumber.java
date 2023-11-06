package lotto.domain;

import java.util.List;
import lotto.utils.StringUtils;
import lotto.validation.BonusNumberValidation;
import lotto.validation.LottoNumberValidation;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(String win, String b) {
        this.numbers = StringUtils.split(win);
        this.bonus = StringUtils.convertToInt(b);
        new LottoNumberValidation().validate(numbers);
        new BonusNumberValidation().validate(numbers, bonus);
    }
}
