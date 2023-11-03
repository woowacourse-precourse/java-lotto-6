package lotto.domain;

import java.util.List;
import lotto.utils.StringUtils;
import lotto.validation.LottoNumberValidation;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(String s) {
        this.numbers = StringUtils.split(s);
        new LottoNumberValidation().validate(numbers);
    }
}
