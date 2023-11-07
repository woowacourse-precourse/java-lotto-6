package domain;

import validator.LottoValidator;

import java.util.List;

public class WinningNumber {

    public WinningNumber(List<Integer> numbers){
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validSize(numbers);
        LottoValidator.validDuplcate(numbers);
        LottoValidator.validRange(numbers);
    }
}
