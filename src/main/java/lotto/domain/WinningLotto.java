package lotto.domain;

import java.util.List;
import lotto.validator.WinningLottoValidator;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        WinningLottoValidator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }


}
