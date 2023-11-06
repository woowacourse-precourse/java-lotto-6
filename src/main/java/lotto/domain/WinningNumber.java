package lotto.domain;

import java.util.List;
import lotto.utils.StringUtils;
import lotto.validation.LottoNumberValidation;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String s) {
        this.numbers = StringUtils.split(s);
        new LottoNumberValidation().validate(numbers);
    }
}
