package lotto.vo;

import java.util.List;
import lotto.validator.LottoNumberValidator;
import lotto.validator.NumberValidator;

public record WinningLottoNumbers(List<Integer> value) {
    public WinningLottoNumbers {
        LottoNumberValidator.validate_MIN_SIZE(value);
    }

    public List<Integer> value() {
        return value;
    }

}
