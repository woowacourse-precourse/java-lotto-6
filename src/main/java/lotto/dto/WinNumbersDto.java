package lotto.dto;

import lotto.domain.Lotto;
import lotto.util.ErrorMessage;

import java.util.List;

public record WinNumbersDto(List<Integer> winNumbers, int bonusNumber) {

    private static final int START_INCLUSIVE_LOTTO_NUMBER = 1;
    private static final int END_INCLUSIVE_LOTTO_NUMBER = 45;

    public WinNumbersDto {
        validate(winNumbers, bonusNumber);
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        new Lotto(winNumbers); // 생성자를 통해 로또 번호 검증
        validateBonusNumberInRange(bonusNumber);
        validateDuplicatedBonusNumber(winNumbers, bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < START_INCLUSIVE_LOTTO_NUMBER || bonusNumber > END_INCLUSIVE_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicatedBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
