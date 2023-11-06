package lotto.domain;

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
}
