package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.validator.Validator;
import lotto.util.validator.ValidatorFactory;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getValidator(Lotto.class);
        validator.validate(numbers);
    }

    public LottoResult getResult(Lotto winningLotto, int bonusNumber) {
        int winningCount = countMatchingNumbers(winningLotto);
        boolean bonusNumberMatching = numbers.contains(bonusNumber);
        return LottoResult.of(winningCount, bonusNumberMatching);
    }

    private int countMatchingNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
