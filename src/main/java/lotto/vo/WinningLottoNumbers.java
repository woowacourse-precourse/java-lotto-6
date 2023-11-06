package lotto.vo;

import java.util.List;
import lotto.validator.WinningLottoNumberValidator;

public record WinningLottoNumbers(List<Integer> value) {
    public WinningLottoNumbers {
        WinningLottoNumberValidator.validate_MIN_SIZE(value);
    }

    public List<Integer> value() {
        return value;
    }

    public List<Integer> add(int bonus_number) {
        value.add(bonus_number);
        WinningLottoNumberValidator.validate_MAX_SIZE(value);
        return value;
    }
}
