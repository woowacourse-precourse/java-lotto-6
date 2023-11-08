package lotto.dto;

import lotto.domain.Lotto;
import lotto.util.consts.ErrorMessage;
import lotto.util.consts.IntValueConst;

import java.util.List;

public record WinNumbersDto(List<Integer> winNumbers, int bonusNumber) {

    public WinNumbersDto {
        validate(winNumbers, bonusNumber);
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        new Lotto(winNumbers); // 생성자를 통해 로또 번호 검증
        validateBonusNumberInRange(bonusNumber);
        validateDuplicatedBonusNumber(winNumbers, bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < IntValueConst.START_INCLUSIVE_LOTTO_NUMBER.getValue() ||
                bonusNumber > IntValueConst.END_INCLUSIVE_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicatedBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
