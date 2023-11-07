package lotto.model.lotto;

import java.util.List;
import lotto.validator.LottoValidator;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
