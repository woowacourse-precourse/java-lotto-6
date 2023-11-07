package lotto.domain;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> lottoNumber) {
        validate(bonusNumber, lottoNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber, List<Integer> lottoNumber) {
        validateIsDigit(bonusNumber);
        validateNumberRange(bonusNumber);
        validateDuplication(bonusNumber, lottoNumber);
    }

    private void validateDuplication(String bonusNumber, List<Integer> lottoNumber) {
    }

    private void validateNumberRange(String bonusNumber) {
    }

    private void validateIsDigit(String bonusNumber) {
        
    }
}
