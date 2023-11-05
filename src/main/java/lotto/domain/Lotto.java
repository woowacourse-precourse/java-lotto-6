package lotto.domain;

import java.util.List;
import lotto.common.validate.Validate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);;
    }

    private List<Integer> validate(List<Integer> numbers) {
        try {
            Validate.sixHitLottoNumberValidate(numbers);
            return numbers;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
