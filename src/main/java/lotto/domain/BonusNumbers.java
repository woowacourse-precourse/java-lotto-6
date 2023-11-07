package lotto.domain;

import lotto.validation.DomainValidate;

import java.util.List;

public class BonusNumbers extends UserNumbers {
    public BonusNumbers(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void validate(List<Integer> numbers) {
        super.validate(numbers);
        DomainValidate.validateNumberOfBonus(numbers);
    }
}
