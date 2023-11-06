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

    public void add(String bonus_number) {
        NumberValidator.validate(bonus_number);
        value.add(Integer.parseInt(bonus_number));
        LottoNumberValidator.validate_MAX_SIZE(value);
    }
}
