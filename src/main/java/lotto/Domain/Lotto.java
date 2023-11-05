package lotto.Domain;

import java.util.List;
import lotto.Validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.doValidate(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean hasNumber(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
