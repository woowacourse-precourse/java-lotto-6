package lotto.model.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLotto(){
        return Collections.unmodifiableList(numbers);
    }
}
