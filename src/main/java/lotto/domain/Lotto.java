package lotto.domain;
import lotto.util.LottoNumberGenerator;
import lotto.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto{

    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int checkWinningNumbers(List<Integer> winningLotto) {
        return 0;
    }
}
