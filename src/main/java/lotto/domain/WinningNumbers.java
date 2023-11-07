package lotto.domain;

import lotto.validation.DomainValidate;

import java.util.List;

public class WinningNumbers extends UserNumbers {

    public WinningNumbers(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    protected void validate(List<Integer> numbers) {
        super.validate(numbers);
        DomainValidate.validateNumberOfWinningNumbers(numbers);
    }
}
