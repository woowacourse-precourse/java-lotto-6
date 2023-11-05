package lotto.domain;

import java.util.List;
import lotto.validator.WinningLottoValidator;

public class WinningLotto {

    public WinningLotto(List<Integer> numbers) {
        WinningLottoValidator.validateWinningNumbers(numbers);
    }
}
